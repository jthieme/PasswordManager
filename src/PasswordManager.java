import java.util.Arrays;
import java.util.Scanner;

// Allow for the user to do the following:
// 1. Add a password
// 2. Edit an existing password
// 3. Delete an existing password
// 4. Save all passwords in an encrypted folder on their local machine
// 5. Allow the passwords to be decrypted when the correct Master password is entered

// Ways to make this better:
// OOP Design
// Include what account this password belongs to (website, application, etc.)
// Include the associated email of this password
// Save all information in a JSON Object Array

// TODO:
// Separate into functions
// Include while loop (while choice != 4 (exit)), continue to print the menu
public class PasswordManager {
    public static void display(){
        // Display welcome screen
        System.out.println("Welcome to the Password Manager!");
        System.out.println("Please select what you would like to do: ");
    }

    public static void menu(){
        // Display available options
        System.out.println("1. Add a new password\n2. Edit an existing password\n3. Delete an existing password\n4. Exit");

        // Display carrot
        System.out.print("\n> ");
    }
    public static void main(String[] args){
        // Display welcome screen
        display();

        // Display available options
        menu();

        // Get user input for options
        Scanner obj = new Scanner(System.in);
        int choice = obj.nextInt();

        // Create password array
        String passwords[];
        passwords = new String[0];

        // Determine the choice
        switch (choice){
            // If user wants to add a password to the collection,
            case 1:
                // Prompt them to enter a password
                System.out.println("Enter your password: ");

                // Allow them to type in their password
                String newPassword = obj.next();

                // Make a copy of original array, then include an additional spot
                passwords = Arrays.copyOf(passwords, passwords.length + 1);

                // Set the new password to the new spot of the array
                passwords[passwords.length-1] = newPassword;

                // Display their newly entered password
                System.out.println("Your new password is: " + newPassword);
                break;
            case 2:
                System.out.println("Edit which password: ");
                break;
            case 3:
                System.out.println("Delete which password? ");
                break;
            case 4:
                break;
        }

    }
}
