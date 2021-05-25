package ver_entschlüsselung;

abstract class Cipher {

    private String userInput;
    private String userOutput;
    private String key;

    public Cipher(String userInput, String userOutput, String key) {
        this.userInput = userInput;
        this.userOutput = userOutput;
        this.key = key;
    }

    public String getUserInput() {
        return userInput;
    }
    public void setUserInput(String userInput) {
        this.userInput = userInput;
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

    abstract String Encode (String userInput, String key);
    abstract String Decode (String userInput, String key);
}
