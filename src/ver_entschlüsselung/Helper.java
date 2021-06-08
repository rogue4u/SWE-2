package ver_entschlüsselung;

//Helper Class to deal with certain things
public class Helper {
    static final int start = (int)'a';
    static final int end = (int)'z';
    //Moves the Char on a given Int value
    public static char Shift(char letter, int shift){
        if(letter>='a' && letter <='z'){
            letter += shift;
            //After z comes a
            if (letter > 'z') letter -= 26;
        }
        return letter;
    }
    public static char calcCurrent(char c, int shift) {
        return 'a';
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
    //returns a Index of a Letter in a Alphabetic Array form(lower case)
    public static int getIndex(char val) {
        return (int)val - start;
    }
    //convert a char[] to String
    public static String getString(char[] arr) {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }
}
