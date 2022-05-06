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
        // Open up dialog box to choose where to save files
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        file.showSaveDialog(null);

        // Convert path location to string
        fileDestination = file.getSelectedFile().toString();
        return fileDestination;
    }
    public String saveMasterPassword(String masterPass) {
        // Save the master password to the selected destination
        try {
            // Write file destination to the users file destination, with the master password file, containing the master password
            Files.write(Paths.get(fileDestination+"/"+MASTER_FILE), masterPass.getBytes());
        // If there's an error
        } catch (IOException e) {
            // Tell me exactly where to find it
            e.printStackTrace();
        }
        return MASTER_FILE;
    }
    public String savePasswordsToFile(String passwordArray) {
        // Save the password array to the selected destination
        try {
            // Write files to the users file destination, with the password file, containing the array
            Files.write(Paths.get(fileDestination+"/"+PASS_FILE), passwordArray.getBytes());
        // If there's an error
        } catch (IOException e) {
            // Tell me exactly where to find it
            e.printStackTrace();
        }
        return PASS_FILE;
    }
    public String getFileDestination() {
        return fileDestination;
    }

    public String saveUserFileInfo() {
        // If there is no file destination set
        if (fileDestination == null) {
            // Have user select one
            selectDestination();
        }
        // Write the users selected file destination for easy lookup when they log in later
        else {
            try {
                Files.write(Paths.get(userFileDestination), fileDestination.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                // Return the contents
                return line;
            }
            return line;
            // Otherwise, create the file
        } catch (IOException x) {
            // Save the users file destination
            System.out.println("Please select where you want your files saved to: ");
            saveUserFileInfo();
        }
        return line;
    }
}
