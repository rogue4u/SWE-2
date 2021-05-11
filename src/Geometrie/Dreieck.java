package Geometrie;

import java.util.Arrays;

import plotter.Plotter;

public class Dreieck extends Form {

	public Dreieck(Punkt p1, Punkt p2, Punkt p3) {
		punkte = new Punkt[3];
		punkte[0] = p1;
		punkte[1] = p2;
		punkte[2] = p3;
	}

	@Override
	public String toString() {
		return "Dreieck [punkte=" + Arrays.toString(punkte) + "]";
	}

	public void zeichnen(Plotter plotter) {
		plotter.nextDataSet();
		for (Punkt p : punkte) {
			plotter.add(p.x, p.y);
		}
		plotter.add(punkte[0].x, punkte[0].y);
	}
}
