package ver_entschlüsselung;

public class VigenereCipher extends Cipher {

    private char[][] table;
    private int inertialShift;

    public VigenereCipher(String userInput, String userOutput, String key) {
        super(userInput, userOutput, key);
        //Fill the table
        table = FillTable(new char[26][26], key, 0);
    }
    public VigenereCipher(String userInput, String userOutput, String key, int inertialShift) {
        super(userInput, userOutput, key);
        //Fill the table
        table = FillTable(new char[26][26], key, inertialShift);
        this.inertialShift = inertialShift;
    }

    public String Encode (String userInput, String key) {
        System.out.println("Vigenere cipher Encoded!");
        String userOutput = userInput + key;
        return userOutput;
    }

    public String Decode (String userInput, String key) {
        System.out.println("Vigenere cipher Decoded!");
        String userOutput = userInput + key;
        return userOutput;
    }

    //Fill the encode table with chars
    private char[][] FillTable(char[][] table, String key, int inertialShift) {
        char current;
        for (int y = 0; y < 26; y++) {
            current = (char)('a' + y + inertialShift);
            for (int x = 0; x < 26; x++) {
                if (current > 'z')
                    current -= (char)26;
                table[x][y] = current++;
            }
        }
        Helper.PrintTable(table);
        return table;
    }
}
