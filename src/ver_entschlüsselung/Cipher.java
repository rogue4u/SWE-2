package ver_entschlüsselung;

import jserver.XSendAdapterEN;

abstract class Cipher {

    //Variablen erstellen
    private String name;
    private int version;

    //Konstruktor
    public Cipher(String name, int version) {
        this.name = name;
        this.version = version;
    }

    //Gibt den Namen Zurück
    public String getName() {
        return name;
    }

    //GIbt die Version zurück
    public int getVersion() {
        return version;
    }

    //Decode & Encode Methoden
    abstract String Encode (String userInput, String key, XSendAdapterEN xsend);
    abstract String Decode (String userInput, String key, XSendAdapterEN xsend);
}
