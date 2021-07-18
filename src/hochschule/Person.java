package hochschule;



class Person {

    private String vorname;
    private String name;

    public Person(String vorname, String name) {
        this.vorname = vorname;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getVorname() {
        return vorname;
    }

    @Override
    public String toString() {
        return vorname + " " + name;
    }



}
