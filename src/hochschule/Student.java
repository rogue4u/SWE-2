package hochschule;



public class Student extends Person {

    int CP = 0;
    int matrikelNummer = 0;
    int fachsemester = 0;

    public Student(String name, String vorname, int CP) {

        super(name, vorname);
        this.CP = CP;

    }

    @Override
    public String toString() {
        return super.toString() + ", " + CP + " CPs";
    }

    public int getCP() {
        return CP;
    }

    public void erhoeheCP (int p) {
        CP += p;
    }

}
