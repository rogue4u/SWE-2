package Question;

import java.util.Random;

/**
 * Generator für Rechenaufgaben
 *
 * Beispielhaft sind fuer getAdd zwei Versionen implementiert. Bei einer kann
 * man den Maximalwert angeben, die andere verwendete einen Standardwert.
 *
 * Zum Erzeugen der Zufallswerte wird die Bibliotheksklasse Random verwendet.
 *
 * @author Euler
 *
 */
public class QuestionGenerator {
    static private Random random = new Random();
    static private int anzahl;
    static private int maxAdd = 20;
    static private int maxMult = 10;

    public static int getAnzahl() {
        return anzahl;
    }

    public static OpenQuestion getAdd() {
        return getAdd(maxAdd);
    }

    public static OpenQuestion getAdd(int max) {
        ++anzahl;
        int a = random.nextInt(max);
        int b = random.nextInt(max);
        return new OpenQuestion(a + "+" + b, "" + (a + b));
    }

    public static OpenQuestion getMult() {
        ++anzahl;
        int a = random.nextInt(maxMult);
        int b = random.nextInt(maxMult);
        return new OpenQuestion(a + "*" + b, "" + (a * b));
    }

}