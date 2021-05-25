package ver_entschlüsselung;

public class VigenereCipher extends Cipher {

    public VigenereCipher(String userInput, String userOutput, String key) {
        super(userInput, userOutput, key);
    }

    public String encode (String userInput, String key) {
        System.out.println("Vigenere cipher Encoded!");
        String userOutput = userInput + key;
        return userOutput;
    }

    public String decode (String userInput, String key) {
        System.out.println("Vigenere cipher Decoded!");
        String userOutput = userInput + key;
        return userOutput;
    }
}
