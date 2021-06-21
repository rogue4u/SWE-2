package ver_entschlüsselung;

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
        if(letter>=first_lc && letter <=last_lc){
            letter += shift;
            //After z comes a
            if (letter > last_lc) letter -= 26;
        } else if(letter>=first_uc && letter <=last_uc) {
            letter += shift;
            if (letter > last_uc) letter -= 26;
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
    public static int getIndex(char val) {
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
}
