package ver_entschlüsselung;

abstract class Cipher {

    private String name;
    private int version;

    public Cipher(String name, int version) {
        this.name = name;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    abstract String Encode (String userInput, String key);
    abstract String Decode (String userInput, String key);
}
