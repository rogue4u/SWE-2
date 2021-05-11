package Geometrie;

import plotter.Plotter;

public class Quadrat extends Form {
	double laenge;
	
	public Quadrat(Punkt p1, double d) {
		punkte = new Punkt[1];
		punkte[0] = p1;
		laenge = d;
	}

	@Override
	public void zeichnen(Plotter plotter) {
		plotter.nextDataSet();
		plotter.add( punkte[0].x, punkte[0].y);
		plotter.addD(  laenge, 0 );
		plotter.addD(  0, laenge );
		plotter.addD(  -laenge, 0 );
		plotter.addD(  0, -laenge );

	}

}
