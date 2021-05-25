package ver_entschlüsselung;

//Helper Class to deal with certain things
public class Helper {
    //Moves the Char on a given Int value
    public static char shift(char letter, int shift){
        if(letter>='a' && letter <='z'){
            letter += shift;
            //After z comes a
            if (letter > 'z') letter -= 26;
        }
        return letter;
    }
}
