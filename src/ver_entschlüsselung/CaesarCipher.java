package ver_entschlüsselung;

import java.util.Locale;

public class CaesarCipher extends Cipher{

    //Konstruktor
    public CaesarCipher(String userInput, String userOutput, String key) {
        super(userInput, userOutput, key);
    }

    //Verschlüsselt den UserInput und gibt Verschlüsselten UserOutput zurück
    @Override
    public String encode (String userInput, String key) {
        String userOutput = "";
        userInput = userInput.toLowerCase(Locale.ROOT); // Alles in kleinbuchstaben
        for(int i=0; i<userInput.length(); i++){
            //Buchstaben verschieben und an Geheimtext haengen
            char next = userInput.charAt(i);
            userOutput = userOutput + shift(next, key.length());
        }
        System.out.println("Caesar cipher Encoded!");
        return userOutput;
    }

    //Entschlüsselt den UserInput und gibt Entschlüsselten UserOutput zurück
    @Override
    public String decode (String userInput, String key) {
        String userOutput = "";
        userInput = userInput.toLowerCase();
        for(int i=0; i<userInput.length(); i++){
            char next = userInput.charAt(i);
            userOutput = userOutput + shift(next, 26-key.length());
        }
        return userOutput;
    }

    //Verschiebt den Buchstaben um die angegebene Verschiebung (key)
    public static char shift(char letter, int shift){
        if(letter>='a' && letter <='z'){
            letter += shift;
            while(letter > 'z'){
                letter -= 26;
            }
        }
        return letter;
    }

}
