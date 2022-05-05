import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PasswordFiles {
    final String MASTER_FILE = "masterPassword.txt";
    String PASS_FILE = "passwords.txt";
    String userFileDestination = "C:/Users/jomth/userFiles.txt";
    String fileDestination;
    JFileChooser file = new JFileChooser();
    Scanner passFileName = new Scanner(System.in);
    String line = null;
    Password p = new Password();


    public String selectDestination() {
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        file.showSaveDialog(null);

        //System.out.println(file.getSelectedFile());
        fileDestination = file.getSelectedFile().toString();
        return fileDestination;
    }
    public String saveMasterPassword(String masterPass) {
        try {
            Files.write(Paths.get(fileDestination+"/"+MASTER_FILE), masterPass.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MASTER_FILE;
    }
    public String savePasswordsToFile(String passwordArray) {
        try {
            Files.write(Paths.get(fileDestination+"/"+PASS_FILE), passwordArray.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return PASS_FILE;
    }
    public String getPasswordFileName() {
        System.out.println("Enter password file name (without file type (.txt, etc.)): ");
        passFileName.next();

        return passFileName.toString();
    }

    public void getFileDestination() {
        System.out.println("\nYour files have been saved to: " + "\n" + fileDestination);
    }

    public String saveUserFileInfo() {
        if (fileDestination == null) {
            selectDestination();
        }
        try {
            Files.write(Paths.get(userFileDestination), fileDestination.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userFileDestination;
    }

    public String getUserDestination() {
        return userFileDestination;
    }

    public String readFile(String searchFile) {
        // Turn string into path
        Path file = Paths.get(searchFile);
        // Try to read the file
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {

            // If file is there and not empty, then read and save its contents
            while ((line = reader.readLine()) != null) {
                // Read the user selected location
                if (line.contains("\\\\")) {
                    line.replace("\\", File.separator);
                }
                readFile(line+"/"+MASTER_FILE);
            }
            // Otherwise, create the file
        } catch (IOException x) {
            // System.err.println(x);

            // Save the users file destination
            System.out.println("Please select where you want your files saved to: ");
            saveUserFileInfo();
        }
        return line;

    }


}
