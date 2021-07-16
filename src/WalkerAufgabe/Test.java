package WalkerAufgabe;

import plotter.Graphic;
import plotter.Plotter;

public class Test {

	public static void main(String[] args) {
		Graphic graphic = new Graphic();
		Plotter plotter = graphic.getPlotter();

		Function f = new Lin(200, 3);
		Function f2 = new Exp(4, 2);
		Function f3 = f2.getAbleitung();

		for (double x = 0; x <= 1; x += 0.1) {
			System.out.println(x + " =  " + f.calcValue(x));
			System.out.println(x + " =  " + f2.calcValue(x));
			System.out.println(x + " =  " + f3.calcValue(x));
			plotter.add( "f", f.calcValue(x));
			plotter.add( "f1", f2.calcValue(x));
			plotter.add( "f2", f3.calcValue(x));
		}
		System.out.println("Aufrufe: " + Function.getZaehler());
	}

}
