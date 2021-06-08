package ver_entschlüsselung;

import java.util.Locale;

public class VigenereCipher extends Cipher {
    public static void main(String[] args) {
        VigenereCipher akey = new VigenereCipher("", "", "akey");
        System.out.println(akey.Encode("geheimnis", "akey"));
    }
    final int start = (int)'a';
    final int end = (int)'z';

    private char[][] table;
    private char[] ignoreChars = {'ß', 'ö', 'ä', 'ü', '.', ',', ':', ';', '-', '_', '#', '+', '*', ' '};

    public VigenereCipher(String userInput, String userOutput, String key) {
        super(userInput, userOutput, key);//TODO: IGNORE THIS
        //Fill the table
        table = FillTable(new char[26][26], 0);
    }
    public VigenereCipher(String userInput, String userOutput, String key, int inertialShift) {
        super(userInput, userOutput, key);//TODO: IGNORE THIS
        //Fill the table
        table = FillTable(new char[26][26], inertialShift);
    }

    public String Encode (String userInput, String key) {
        System.out.println("Vigenere cipher Encoded!");
        char[] _uInput = userInput.toLowerCase(Locale.ROOT).toCharArray();
        char[] _uKey = key.toCharArray();
        int step = 0;

        for (int i = 0; i < _uInput.length; i++) {
            //ignore some chars
            if (Contains(ignoreChars, _uInput[i])) continue;
            if (step == _uKey.length) step = 0;
            _uInput[i] = getChar(_uInput[i],_uKey[step++] , false);
        }
        return getString(_uInput);
    }

    public String Decode (String userInput, String key) {
        System.out.println("Vigenere cipher Decoded!");
        String userOutput = userInput + key;
        return userOutput;
    }

    //Fill the Vigenere table with chars
    private char[][] FillTable(char[][] table, int inertialShift) {
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
    //checks if a char[] contains a char
    private boolean Contains(char[] arr, char val) {
        for (char item : arr) {
            if (item == val)
                return true;
        }
        return false;
    }
    //converts a Letter to a encoded one to a decoded one or vise versa
    private char getChar(char val, char key, boolean reverse) {
        if (!reverse) {
            return table[getIndex(val)][getIndex(key)];
        } else {
            return ' ';
        }
    }
    //returns a Index of a Letter in a Alphabetic Array form(lower case)
    private int getIndex(char val) {
        return (int)val - start;
    }
    //convert a char[] to String
    private String getString(char[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }
}
