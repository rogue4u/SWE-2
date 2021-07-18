package hochschule;



public class Professor extends Person implements Lehrkraft{

    int dienstjahre;
    int SWS;

    public Professor(String name, String vorname, int dienstjahre) {
        super(name, vorname);
        this.dienstjahre = dienstjahre;
    }

    public void uebernehmeVorlesung(String vorlesung, int stunden) {
        System.out.println( "Prof. " + getName()
                + " übernimmt " + vorlesung);
        SWS += stunden;
        System.out.println( "SWS: " + SWS);
    }

}