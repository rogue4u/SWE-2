package ver_entschlüsselung;

//Helper Class to deal with certain things
public class Helper {
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
}
