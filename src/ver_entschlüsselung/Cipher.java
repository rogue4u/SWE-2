package ver_entschlüsselung;

public class Cipher {

    private String userInput;
    private String userOutput;
    private String key;

    public Cipher(String userInput, String userOutput, String key) {
        this.userInput = userInput;
        this.userOutput = userOutput;
        this.key = key;
    }

    public String getUserOutput() {
        return userOutput;
    }

    public void setUserOutput(String userOutput) {
        this.userOutput = userOutput;
    }

    public String getKey() {
        return key;
    }

    public String encode (String userInput, String key){
        System.out.println("Encoded!");
        return "Test";
    }

    public String decode (String userInput, String key){
        System.out.println("Decoded!");
        return "Test";
    }
}
