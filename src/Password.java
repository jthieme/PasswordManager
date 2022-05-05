import java.util.Arrays;
import java.util.Hashtable;

public class Password {
    static String[] passwords = new String[0]; // Create empty password array
    static Hashtable<String, String> dict = new Hashtable<String, String>();
    static String type;
    static String email;
    static String masterPass;

    public static String createMaster(String master){
        master = masterPass;
        return masterPass;
    }
    public static String setType(String key){
        type = key;
        return type;
    }
    public static String setEmail(String eMail) {
        email = eMail;
        return email;
    }
    public static String create(String newest){

        // Add items to the dictionary
        dict.put("NameOfService", type);
        dict.put("Email", email);
        dict.put("Password", newest);

        // Make a copy of original array, then include an additional spot
        passwords = Arrays.copyOf(passwords, passwords.length + 1);

        // Set the new password to the new spot of the array
        passwords[passwords.length - 1] = dict.toString();

        return newest;
    }

    public static void view(){
        System.out.println(Arrays.toString(passwords));
    }

    public static String newest(String newest){
        // If the array is empty
        if (dict.size() == 0){
            // Create a new password array
            create(newest);
        }
        // Otherwise, add to the array
        else
            create(newest);

        return newest;
    }

    public static String getArray() {
        return Arrays.toString(passwords);
    }

    public static String getMasterPass() {
        return masterPass;
    }

}
