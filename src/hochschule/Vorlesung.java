package hochschule;

public class Vorlesung {

    String name;
    int stunden = 2;

    public Vorlesung(String n, Lehrkraft lk) {
            name = n;
        lk.uebernehmeVorlesung(name, stunden);
    }

}