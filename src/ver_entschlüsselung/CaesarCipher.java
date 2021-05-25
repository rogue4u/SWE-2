package ver_entschlüsselung;

import java.util.Locale;

public class CaesarCipher extends Cipher {

    //Constructor
    public CaesarCipher(String userInput, String userOutput, String key) {
        super(userInput, userOutput, key);
    }

    //encodes the userInput and returns the Encoded Text
    public String encode (String userInput, String key) {
        String userOutput = "";
        //ToLowerCase to not deal with Capitals
        userInput = userInput.toLowerCase(Locale.ROOT); // All to Lowercase
        for(int i=0; i<userInput.length(); i++){
            //Move letter and add it to the Secret text
            char next = userInput.charAt(i);
            userOutput = userOutput + Helper.shift(next, key.length());
        }
        System.out.println("Caesar cipher Encoded!");
        return userOutput;
    }

    //Decodes the userInput and returns the Decoded Text
    public String decode (String userInput, String key) {
        String userOutput = "";
        userInput = userInput.toLowerCase();
        for(int i=0; i<userInput.length(); i++){
            char next = userInput.charAt(i);
            userOutput = userOutput + Helper.shift(next, 26-key.length());
        }
        return userOutput;
    }

}
