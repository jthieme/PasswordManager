import java.util.Scanner;

// Allow for the user to do the following:
// 1. Add a password
// 2. Edit an existing password
// 3. Delete an existing password
// 4. Save all passwords in an encrypted folder on their local machine
// 5. Allow the passwords to be decrypted when the correct Master password is entered
// 6. View all the passwords as long as the master password has been provided

// TODO:
// Upon every start after first, have user enter in master password
// Decrypt passwords once the master password has been entered
// Upon exiting, have user select password safe destination
// Save and encrypt passwords to users selected destination
public class PasswordManager {
    // Set the private member variables
    static Scanner master = new Scanner(System.in); // Initialize scanner object for master password
    static String masterPassword; // Initialize master password variable

    static Scanner choose = new Scanner(System.in); // Get user input for options
    static String choice = null;

    static Password p = new Password(); // Instantiate password object
    static File f = new File(); // Instantiate file object


    public static void welcome(){
        // Display welcome screen
        System.out.println("Welcome to the Password Manager!");
    }

    public static void carrot(){
        // Display carrot
        System.out.print("\n> ");
    }

    public static String createMasterPassword(){

        // Display to user the need for master password
        System.out.println("Please create your master password.");

        // Display carrot
        carrot();

        // Set masterPassword to receive user input
        masterPassword = master.next();
        p.createMaster(masterPassword);

        // Return the masterPassword
        return masterPassword;
    }

    public static void menu(){
        // Instruct user to make a selection
        System.out.println("\nPlease select what you would like to do: ");

        // Display available options
        System.out.println("1. Add a new password\n2. Edit an existing password\n3. Delete an existing password\n4. View passwords\n5. Exit");

        // Display carrot
        carrot();
    }
    public static void main(String[] args){
        // Display welcome screen
        welcome();

        // If not the first time using the program
        /*if (f.doesPathExist()) {
            // Enter your existing password
            System.out.println("Please enter your master password: ");
            // Find the master password file
            // Compare it with what was entered
            // If it matches, keep going

        }
        // Otherwise, create your master password and other passwords
        else {
            // Get user to create their master password
            createMasterPassword();
        }*/

        createMasterPassword();

        while (!"5".equals(choice)) {
            // Display available options
            menu();
            choice = choose.next();



            // If user wants to add a password to the collection,
            if ("1".equals(choice)) {
                System.out.println("Enter the service name: ");
                String serviceName = choose.next();
                p.setType(serviceName);


                // Prompt them to enter a password
                System.out.println("\nEnter your password: ");
                carrot();

                // Allow them to type in their password
                String newPassword = choose.next();

                // Get the new password
                p.newest(newPassword);

                // Reset the choice
                choice = null;
            }
            if ("2".equals(choice)) {
                System.out.println("Edit which password: ");
                carrot();

                // Reset the choice
                choice = null;
            }
            if ("3".equals(choice)) {
                System.out.println("Delete which password? ");
                carrot();

                // Reset the choice
                choice = null;
            }
            if ("4".equals(choice)) {
                // View all the passwords
                System.out.println("Here's a list of your passwords and the service they belong to: ");
                p.view();
            }
            if ("5".equals(choice)) {
                // Have user select where they want to save their passwords
                System.out.println("Please select the folder where you want your files saved to: ");
                f.selectDestination();

                // Save the file destination
                f.savePathDestination();

                // Save master password at that location
                f.saveMasterPassword(masterPassword);

                // Save the passwords at that location
                f.savePasswordsToFile(p.getArray());

                System.out.println("Goodbye!");

                // End the Program
                break;
            }

        }
    }
}
