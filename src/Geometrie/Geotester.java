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

	/*
		Dreieck d1 = new Dreieck(p1, p2, p3);
		System.out.println(d1);
		d1.zeichnen(plotter);
		d1.bewegeUm(1, 1);
		d1.zeichnen(plotter);
	*/
	/*
		Kreis k1 = new Kreis(p1, 1.6);
		System.out.println(k1);
		k1.zeichnen(plotter);
		k1.bewegeUm(2, -1);
		k1.zeichnen(plotter);
	*/
		Sinus s1 = new Sinus(p1,p2);
		System.out.println(s1);
		s1.zeichnen(plotter);

		/*
		Form formen[] = { new Dreieck(p1, p2, p3), new Quadrat(p1, 1.6), new Linie( new Punkt(0,0), new Punkt(2,2)) };
		for( Form form : formen  ) {
			System.out.println( form );
			form.zeichnen( plotter );
			form.bewegeUm(2., 2);
			form.zeichnen( plotter );
		}

		*/
	}

}
