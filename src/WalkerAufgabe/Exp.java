package WalkerAufgabe;

public class Exp extends Function {
	double c;
	double d;

	public Exp(double c, double d) {
		this.c = c;
		this.d = d;
	}

	@Override
	public double calcValue(double x) {
		++zaehler;
		return c*Math.exp( d * x) ;
	}

	@Override
	public Function getAbleitung() {
		return new Exp( c*d, d);
	}

}
