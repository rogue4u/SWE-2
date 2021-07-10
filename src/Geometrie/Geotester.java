package Geometrie;

import java.awt.Color;

import plotter.Graphic;
import plotter.Plotter;

public class Geotester {

	public Geotester() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		Graphic graphic = new Graphic("Geometrie");
		Plotter plotter = graphic.getPlotter();
		plotter.setRange(-1., 11);
		plotter.setAutoIncrementColor(false);

		Punkt p1 = new Punkt(1, 1);
		Punkt p2 = new Punkt(6, 5);
		Punkt p3 = new Punkt(3, 7);

		System.out.println(p1);
		p1.bewegeUm(1., 2.);
		System.out.println(p1);

        Sinus s1 = new Sinus(p1,p2);
		System.out.println(s1);
		s1.zeichnen(plotter);

    }

}
