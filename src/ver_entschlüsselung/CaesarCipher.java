package ver_entschlüsselung;

import jserver.XSendAdapterEN;

public class CaesarCipher extends Cipher {
    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();
        Logger.Log("Cipher/Caeser/test", "" + cipher.Encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ.,:;-_#'+*~!§$%&/()=?{[]}", "EinZiehmlichGeilerKey", null));
        Logger.Log("Cipher/Caeser/test", "" + cipher.Decode("yzabcdefghijklmnopqrstuvwx.,:;-_#'+*~!§$%&/()=?{[]}", "EinZiehmlichGeilerKey", null));
    }

    //Constructor
    public CaesarCipher() {
        super("CaesarCipher", 1);
    }

    //encodes the userInput and returns the Encoded Text
    public String Encode (String userInput, String key, XSendAdapterEN xsend) {
        int iKey = 0;
        //making sure key and User input are lower
        char[] cKey = key.toLowerCase().toCharArray();
        char[] c_userOutput = userInput.toLowerCase().toCharArray();
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

        for (int i = 0; i < c_userOutput.length; i++) {
            if (Helper.Contains(Helper.specials, c_userOutput[i]) | Helper.Contains(Helper.numbers, c_userOutput[i])) continue;
            c_userOutput[i] = Helper.ShiftLetter(c_userOutput[i], iKey);
        }
        Logger.Log("Cipher/Caesar", "Encode Result: " + Helper.getString(c_userOutput));

        return Helper.getString(c_userOutput);
    }

    //Decodes the userInput and returns the Decoded Text
    public String Decode (String userInput, String key, XSendAdapterEN xsend) {
        int iKey = 0;
        char[] cKey = key.toLowerCase().toCharArray();
        char[] c_userOutput = userInput.toLowerCase().toCharArray();
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
        for (int i = 0; i < c_userOutput.length; i++) {
            if (Helper.Contains(Helper.specials, c_userOutput[i]) | Helper.Contains(Helper.numbers, c_userOutput[i])) continue;
            c_userOutput[i] = Helper.ShiftLetter(c_userOutput[i], -iKey);
        }
        Logger.Log("Cipher/Caesar", "Decode Result: " + Helper.getString(c_userOutput));
        return Helper.getString(c_userOutput);
    }

}
