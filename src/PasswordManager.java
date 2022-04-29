import java.util.Scanner;
import java.util.*;

public class PasswordManager {
    public static void main(String[] args){
        // Display welcome screen
        System.out.println("Welcome to the Password Manager!");
        System.out.println("Please select what you would like to do: ");

        // Display available options
        System.out.println("1. Add a new password\n2. Edit an existing password\n3. Delete an existing password\n4. Exit");

        // Display carrot
        System.out.print("\n> ");

        // Get user input for options
        Scanner obj = new Scanner(System.in);
        int choice = obj.nextInt();

        // Create password array
        String passwords[];
        passwords = new String[0];

        switch (choice){
            case 1:
                System.out.println("Enter your password: ");
                String newPassword = obj.next();
                passwords = Arrays.copyOf(passwords, passwords.length + 1);
                passwords[passwords.length-1] = newPassword;
                System.out.println("Your new password is: " + Arrays.toString(passwords));
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
