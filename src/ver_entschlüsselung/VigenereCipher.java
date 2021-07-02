package ver_entschlüsselung;

import jserver.XSendAdapterEN;

import java.util.Locale;

public class VigenereCipher extends Cipher {

    private final char[][] table;

    public VigenereCipher() {
        super("Vigenere", 1);//TODO: IGNORE THIS
        //Fill the table
        table = FillTable(new char[26][26], 0);
    }
    //TODO: IGNORE THIS
    /*public VigenereCipher(String userInput, String userOutput, String key, int inertialShift) {
      *  super(userInput, userOutput, key);
      *  //Fill the table
      *  table = FillTable(new char[26][26], inertialShift);
    }*/

    public String Encode (String input, String key, XSendAdapterEN xsend) {
        Logger.Log("Cipher/Vigenere", "Vigenere cipher Encoded!");
        char[] _uOutput = input.toLowerCase(Locale.ROOT).toCharArray();
        char[] _uInput = _uOutput;
        char[] _uKey = key.toCharArray();
        int step = 0;

        for (int i = 0; i < _uOutput.length; i++) {
            //ignore some chars
            if (Helper.Contains(Helper.specials, _uOutput[i])) continue;
            if (step == _uKey.length) step = 0;
            _uOutput[i] = getChar(_uOutput[i],_uKey[step++] , false);
        }
        Helper.BoardPainter(xsend, table, _uInput, _uOutput, _uKey);
        return Helper.getString(_uOutput);
    }
    public String Decode (String input, String key, XSendAdapterEN xsend) {
        Logger.Log("Cipher/Vigenere", "Vigenere cipher Decoded!");
        //TODO: Vigenere Decode
        char[] _uOutput = input.toLowerCase(Locale.ROOT).toCharArray();
        char[] _uInput = Helper.copy(_uOutput);
        char[] _uKey = key.toCharArray();
        int step = 0;
        for (int i = 0; i < _uOutput.length; i++) {
            if (Helper.Contains(Helper.specials, _uOutput[i])) continue;
            if (step == _uKey.length) step = 0;
            _uOutput[i] = getChar(_uOutput[i],_uKey[step++] , true);
        }
        Helper.BoardPainter(xsend, table, _uInput, _uOutput, _uKey);
        return Helper.getString(_uOutput);
    }

    //Fill the Vigenere table with chars
    private char[][] FillTable(char[][] table, int inertialShift) {
        Logger.Log("Cipher/Vigenere", "Printing table");
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
        Logger.Log("Cipher/Vigenere", "Finished Printing");
        return table;
    }
    //converts a Letter to a encoded one to a decoded one or vise versa
    private char getChar(char val, char key, boolean reverse) {
        if (!reverse) {
            return table[Helper.getIndex(val)][Helper.getIndex(key)];
        } else {
            //TODO: Add reverse char search, is mby working
            return Helper.getCharByIndex(Helper.getIndexOfElement(table[Helper.getIndex(key)], val));
        }
    }

}
