package ver_entschlüsselung;

import jserver.XSendAdapterEN;

public class CaesarCipher extends Cipher {

    //Konstruktor
    public CaesarCipher() {
        super("CaesarCipher", 1);
    }

    //Verschlüsselt den Klartext
    public String Encode (String userInput, String key, XSendAdapterEN xsend) {
        int iKey = 0;
        //making sure key and User input are lower
        char[] cKey = key.toLowerCase().toCharArray();
        char[] _uInput = userInput.toLowerCase().toCharArray();
        char[] _uOutput = Helper.copy(_uInput);
        //Handle Letters in key
        try {
            iKey = Integer.parseInt(key);
            Logger.Log("Cipher/Caesar", "Converted Number | iKey: " + iKey);
        } catch (Exception e) {
            for (char item : cKey) {
                iKey += item;
            }
            Logger.Log("Cipher/Caesar", "Converted Letters | iKey: " + iKey);
        }

        for (int i = 0; i < _uInput.length; i++) {
            if (Helper.Contains(Helper.specials, _uInput[i]) | Helper.Contains(Helper.numbers, _uInput[i])) continue;
            _uInput[i] = Helper.ShiftLetter(_uInput[i], iKey);
        }
        Logger.Log("Cipher/Caesar", "Encode Result: " + Helper.getString(_uInput));
        Helper.BoardPainter(xsend, _uInput, _uOutput);
        return Helper.getString(_uInput);
    }

    //Entschlüsselt ein Text
    public String Decode (String userInput, String key, XSendAdapterEN xsend) {
        int iKey = 0;
        char[] cKey = key.toLowerCase().toCharArray();
        char[] _uInput = userInput.toLowerCase().toCharArray();
        char[] _uOutput = Helper.copy(_uInput);
        //Handle Letters in key
        try {
            iKey = Integer.parseInt(key);
            Logger.Log("Cipher/Caesar", "Converted Number | iKey: " + -iKey);
        } catch (Exception e) {
            for (char item : cKey) {
                iKey += item;
            }
            Logger.Log("Cipher/Caesar", "Converted Letters | iKey: " + -iKey);
        }
        for (int i = 0; i < _uInput.length; i++) {
            if (Helper.Contains(Helper.specials, _uInput[i]) | Helper.Contains(Helper.numbers, _uInput[i])) continue;
            _uInput[i] = Helper.ShiftLetter(_uInput[i], -iKey);
        }
        Logger.Log("Cipher/Caesar", "Decode Result: " + Helper.getString(_uInput));
        Helper.BoardPainter(xsend, _uInput, _uOutput);
        return Helper.getString(_uInput);
    }
}
