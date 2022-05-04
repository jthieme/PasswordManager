import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class PasswordFiles {
    final String MASTER_FILE = "masterPassword.txt";
    String PASS_FILE = "passwords.txt";
    String fileDestination;
    JFileChooser file = new JFileChooser();
    Scanner passFileName = new Scanner(System.in);


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

}
