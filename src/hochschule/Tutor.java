package hochschule;


public class Tutor extends Student implements Lehrkraft {

    float vergütung = 0;

    public Tutor(String name, String vorname, int CP) {
        super(name, vorname, CP);
    }

    public void uebernehmeVorlesung(String vorlesung, int stunden) {
        System.out.println("Tutor " + getName()
                + " übernimmt " + vorlesung);
        vergütung += stunden * 10;
        System.out.println("Vergütung: " + vergütung + " Euro");
    }



}
