import java.util.Arrays;
import java.util.Hashtable;

public class Password {
    static String[] passwords = new String[0]; // Create empty password array
    static Hashtable<String, String> dict = new Hashtable<String, String>();
    static String type;

    public static String setType(String key){
        type = key;
        //System.out.println("type is: " + type);
        return type;
    }
    public static String create(String newest){

        dict.put("NameOfService", type);
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
        else
            create(newest);

        return newest;
    }

}