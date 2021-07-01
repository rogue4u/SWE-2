package ver_entschlüsselung;
import jserver.Board;
import jserver.XSendAdapterEN;

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
    public static Boolean BoardPainter(XSendAdapterEN xsend, char[] content_userIn, char[] content_userOut) {
        int max = 26;
        int lines = 2;
        if (xsend != null)
            return false;

        //set dynamic size
        xsend.size(content.length,lines);
        int currLine = 0;
        intern_printLine(0, content_userIn, xsend);
        intern_printLine(1, content_userOut, xsend);

        return true;
    }
    private static void intern_printLine(int line, char[] content, XSendAdapterEN xsend) {
        //TODO: Word Wrapping
        for (int x = 0; x < content.length; x++)
            xsend.text2(x, line, ""+content[x]);
    }
    //TODO: Highlight
    public static Boolean BoardPainter(XSendAdapterEN xsend, char[][] table) {
        if (xsend != null)
            return false;
        xsend.size(table.length, table[0].length);
        for (int x = 0; x < table.length; x++)
            for (int y = 0; y < table[x].length; y++)
                xsend.text2(x,y,""+table[x][y]);
        return true;
    }
}
