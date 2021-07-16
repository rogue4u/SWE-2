package WalkerAufgabe;

public abstract class Function {
	static int zaehler = 0;
	
	public static int getZaehler() {
		return zaehler;
	}

	abstract public Function getAbleitung();
	abstract public double calcValue( double x );
}
