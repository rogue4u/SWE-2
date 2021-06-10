package ver_entschlüsselung;

import java.util.Locale;

public class CaesarCipher extends Cipher {

    //Constructor
    public CaesarCipher() {
        super("CaesarCipher", 1);
    }

    //encodes the userInput and returns the Encoded Text
    public String Encode (String userInput, String key) {
        String userOutput = "";
        //ToLowerCase to not deal with Capitals
        userInput = userInput.toLowerCase(Locale.ROOT); // All to Lowercase
        for(int i=0; i<userInput.length(); i++){
            //Move letter and add it to the Secret text
            //TODO: Spaces
            char next = userInput.charAt(i);
            userOutput = userOutput + Helper.Shift(next, key.length());
        }
        System.out.println("Caesar cipher Encoded!");
        return userOutput;
    }

    //Decodes the userInput and returns the Decoded Text
    public String Decode (String userInput, String key) {
        String userOutput = "";
        userInput = userInput.toLowerCase();
        //TODO: Spaces
        for(int i=0; i<userInput.length(); i++){
            char next = userInput.charAt(i);
            userOutput = userOutput + Helper.Shift(next, 26-key.length());
        }
        return userOutput;
    }

}
