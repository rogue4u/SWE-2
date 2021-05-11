package Geometrie;

import plotter.Plotter;

public abstract class Form {
	Punkt[] punkte;

	public Form() {
		// TODO Auto-generated constructor stub
	}

	public void bewegeUm(double dx, double dy) {
		for (Punkt p : punkte) {
			p.bewegeUm(dx, dy);
		}
	}

	public abstract void zeichnen(Plotter plotter);

}
