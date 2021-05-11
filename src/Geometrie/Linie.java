package Geometrie;

import java.util.Arrays;

import plotter.Plotter;

public class Linie extends Form {

	public Linie(Punkt p1, Punkt p2) {
		punkte = new Punkt[2];
		punkte[0] = p1;
		punkte[1] = p2;
	}

	@Override
	public String toString() {
		return "Linie [punkte=" + Arrays.toString(punkte) + "]";
	}

	@Override
	public void zeichnen(Plotter plotter) {
		plotter.nextDataSet();
		plotter.add(punkte[0].x, punkte[0].y);
		plotter.add(punkte[1].x, punkte[1].y);


	}

}
