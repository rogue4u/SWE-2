package WalkerAufgabe;

public class Lin extends Function {
	double a, b;
	
	public Lin(double a, double b) {
		this.a = a;
		this.b = b;
	}


	@Override
	public double calcValue(double x) {
		++zaehler;
		return a*x+b;
	}


	@Override
	public Function getAbleitung() {
		return new Lin( 0, a);
	}

}
