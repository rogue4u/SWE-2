package Geometrie;

import java.util.Arrays;

import plotter.Plotter;
import plotter.Sleep;

public class Kreis extends Form {
	double radius;

	public Kreis(Punkt p1, double radius) {
		punkte = new Punkt[1];
		punkte[0] = p1;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Kreis [punkte=" + Arrays.toString(punkte) + ", radius=" + radius + "]";
	}

	public void zeichnen(Plotter plotter) {
		plotter.nextDataSet();
		for (double t = 0; t < 2 * Math.PI; t += 0.01) {
			double x = punkte[0].x + radius * Math.cos(t);
			double y = punkte[0].y + radius * Math.sin(t);
			plotter.add(x, y);
		}

	}


}
