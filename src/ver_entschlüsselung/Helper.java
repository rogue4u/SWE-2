package ver_entschlüsselung;
import jserver.Board;
import jserver.XSendAdapterEN;
import plotter.Sleep;

import java.sql.Time;
import java.time.LocalDateTime;

//Helper Class to deal with certain things
public class Helper {
    public static final char first_lc = 'a';
    public static final char last_lc = 'z';
    public static final char first_uc = 'A';
    public static final char last_uc = 'Z';
    public static final char[] specials = {' ','!','"','#','$','%','&','\'','(',')','*','+',',','-','.','/',':',';','<','=','>','?','@','[','\\',']','^','_','`','{','|','}','~'};
    public static final char[] numbers = new char[] {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public static final char[] alphabet_lc = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j','k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static final char[] alphabet_uc = new char[] {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J','K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    //Moves the Char on a given Int value
    public static char ShiftLetter(char letter, int shift){
        shift %= alphabet_lc.length;
        if(Contains(alphabet_lc, letter)){
            //if the calculated shift value exeeds index
            int tmp = (getIndex(letter) + shift) % alphabet_lc.length;
            // or is minus
            while (tmp < 0)
                tmp += alphabet_lc.length;
            letter = getChar(tmp);
        }
        return letter;
    }
    public static char getCharByIndex(int index) {
        return (char)(first_lc +index);
    }
    public static void PrintTable(char[][] table) {
        for (char[] items: table) {
            for (char item: items) {
                System.out.print(item + ",");
            }
            System.out.println();
        }
    }
    //checks if a char[] contains a char
    public static boolean Contains(char[] arr, char val) {
        for (char item : arr) {
            if (item == val)
                return true;
        }
        return false;
    }
    public static boolean Contains(char[] arr, char[] val) {
        for (char item : val) {
            if (Contains(arr, item))
                return true;
        }
        return false;
    }
    public static boolean ExistOf(char[] arr, char[] val) {
        int checkVal = 0;
        for (char _arr : arr) {
            for (char _val : val) {
                if (_arr == _val) checkVal++;
            }
        }
        if (checkVal == 0) return true;
        else return false;
    }
    public static boolean ExistOfNot(char[] arr, char[] val) {
        int checkVal = 0;
        for (char _arr : arr) {
            for (char _val : val) {
                if (_arr != _val) checkVal++;
            }
        }
        if (checkVal == 0) return true;
        else return false;
    }
    //returns a Index of a Letter in a Alphabetic Array form(lower case)
    public static int getIndexByChar(char val) {
        return (int)val - first_lc;
    }
    //convert a char[] to String
    public static String getString(char[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }
    //TODO: Byte shifting functions
    //returns index of a val in a array, is -1 if not found, basically a find function
    public static int getIndexOfElement(char[] arr, char val) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
    public static char addChar(char val, int shift ) {
        return 0;
    }
    public static char subChar(char val, int shift ) {
        return 0;
    }

    public static char[] copy(char[] arr) {
        char[] out = new char[arr.length];
        for (int i = 0; i < out.length; i++) {
            out[i] = arr[i];
        }
        return out;
    }
    public static int getIndex(char letter) {
        for(int i = 0; i < alphabet_lc.length; i++) {
            if(alphabet_lc[i] == letter) {
                return i;
            }
        }
        return 0;
    }
    public static char getChar(int index) {
        return alphabet_lc[Math.abs(index) % alphabet_lc.length];
    }
    //TODO: Highlight
    //Painter for arrays
    public static Boolean BoardPainter(XSendAdapterEN xsend, char[] content_userIn, char[] content_userOut) {
        if (xsend == null) return false;
        else if (content_userIn.length != content_userOut.length) return false;
        Logger.Log("Helper/BoardPainter", "ping");

        int max = 26; //max char in one Line
        int currChar = 0; // as index
        int lines = 2; // min lines

        lines = (content_userIn.length+26) / (26);
        int lineDefault = lines;

        Logger.Log("Helper/BoardPainter/content_userIn.length", ""+lines);

        xsend.size(max, lines*2);

        Logger.Log("Helper/BoardPainter", "Lines: "+lines);
        //Paint first lines
        for (int i = 0; i < content_userIn.length; i++) {
            if ((currChar+1) >= max) { lines--; currChar = 0; }
            if ((lines) <= 0) break;

            xsend.text2(currChar, lines-1, ""+content_userIn[i]);
            currChar++;
        }
        currChar = 0;
        lines = lineDefault;
        //paint 2nd lines
        for (int i = 0; i < content_userOut.length; i++) {
            if ((currChar+1) >= max) { lines--; currChar = 0; }
            if ((lines) <= 0) break;

            xsend.text2(currChar, lines+lineDefault-1, ""+content_userOut[i]);
            currChar++;
        }
        return true;
    }
    //TODO: Highlight
    //painter for tables
    public static Boolean BoardPainter(XSendAdapterEN xsend, char[][] table, char[] userInput, char[] userOutput, char[] key) {
        if (xsend == null)
            return false;
        //TODO: Coloring
        xsend.clear();
        xsend.size(table.length+1, table[0].length+1);

        for (int i = 0; i < Helper.alphabet_uc.length; i++) {
            xsend.text2(i+1, 26, ""+Helper.alphabet_uc[i]);
            xsend.text2(0, i, ""+Helper.alphabet_uc[25-i]);
        }

        for (int x = 0; x < table.length; x++) {
            for (int y = 0; y < table[0].length; y++) {
                int loc_x = x+1;
                int loc_y = 25-y; //reverse the y axis to represent the table the correct way
                xsend.text2(loc_x, loc_y, "" + table[x][y]);
            }
        }
        return true;
    }
}
