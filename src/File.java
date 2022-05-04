import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class File {
    final String MASTER_FILE = "masterPassword.txt";
    String PASS_FILE = "passwords.txt";
    String PATH_FILE = "C:/noTouchy.txt";
    String fileDestination;
    String pathDestination;
    JFileChooser file = new JFileChooser();
    Scanner passFileName = new Scanner(System.in);
    File myFile = new File();
    boolean pathExist = false;

    /*public void checkIfMasterPasswordAlreadyExists(){
        //myFile
    }

    public void open() {
        //Files.readString(Paths.get(fileDestination));
    }*/
    public String savePathDestination() {
        try {
            Files.write(Paths.get(PATH_FILE), fileDestination.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileDestination;
    }
    public String selectDestination() {
        file.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        file.showSaveDialog(null);

        System.out.println(file.getSelectedFile());
        fileDestination = file.getSelectedFile().toString();
        return fileDestination;
    }
    public String saveMasterPassword(String master) {
        try {
            Files.write(Paths.get(fileDestination+"/"+MASTER_FILE), master.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MASTER_FILE;
    }
    public String savePasswordsToFile(String file) {
        try {
            Files.write(Paths.get(fileDestination+"/"+PASS_FILE), file.getBytes());
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

    public boolean doesPathExist() {
        if (fileDestination != " ") {
            pathExist = true;
        }
        else {
            pathExist = false;
        }
        return pathExist;
    }

    public String getPath(){
        return fileDestination;
    }
}
