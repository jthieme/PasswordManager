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
// Save and encrypt passwords to users selected destination
public class PasswordManager {
    // Set the private member variables
    static Scanner master = new Scanner(System.in); // Initialize scanner object for master password
    static String masterPassword; // Initialize master password variable

    static Scanner choose = new Scanner(System.in); // Get user input for options
    static String choice = null;

    static Password p = new Password(); // Instantiate password object
    static PasswordFiles pf = new PasswordFiles(); // Instantiate file object
    static String checkMaster;
    static String enterMaster;


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
        System.out.println("1. Add a new password\n2. Edit an existing password\n3. Delete an existing password\n4. View passwords\n5. Save & Exit");

        // Display carrot
        carrot();
    }
    public static void main(String[] args){
        // Display welcome screen
        welcome();

        // If it's the users first time with the program
        if (pf.readFile(pf.getUserDestination()) == null){
            // Then create their master password
            createMasterPassword();

        // Otherwise
        } else {
            // Check to see if the master password matches
            String checkUserInfo = pf.readFile(pf.getUserDestination());
            checkMaster = pf.readFile(checkUserInfo+"/"+pf.MASTER_FILE);

            System.out.println("Please enter your master password: ");
            carrot();
            enterMaster = choose.next();
            masterPassword = enterMaster;
            p.createMaster(masterPassword);

            // Otherwise, try again
            // If it matches
            if (checkMaster.equals(enterMaster)) {
                // Welcome back
                System.out.println("Welcome back");
            }
        }



        while (!"5".equals(choice)) {
            // Display available options
            menu();
            choice = choose.next();

            // If user wants to add a password to the collection,
            if ("1".equals(choice)) {
                System.out.println("Enter the service name: ");
                carrot();
                String serviceName = choose.next();
                p.setType(serviceName);

                System.out.println("Enter email for " + serviceName + ": ");
                carrot();
                String email = choose.next();
                p.setEmail(email);

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
                System.out.println("Do Nothing");

                // Reset the choice
                choice = null;
            }
            if ("3".equals(choice)) {
                System.out.println("Delete which password? ");
                carrot();
                System.out.println("Do Nothing");

                // Reset the choice
                choice = null;
            }
            if ("4".equals(choice)) {
                // View all the passwords
                System.out.println("Here's a list of your passwords and the service they belong to: ");
                p.view();
            }
            if ("5".equals(choice)) {
                // Save master password at user specified location
                if (masterPassword.equals(null)) {
                    pf.saveMasterPassword(masterPassword);
                }
                pf.saveUserFileInfo();
                pf.saveMasterPassword(masterPassword);
                // Save the passwords at that location, with the provided name
                pf.savePasswordsToFile(p.getArray());

                // Tell user where their files have been saved to
                System.out.println("\nYour files have been saved to: \n\t" + pf.getFileDestination());

                System.out.println("\nGoodbye!");

                // End the Program
                break;
            }

        }
    }
}
