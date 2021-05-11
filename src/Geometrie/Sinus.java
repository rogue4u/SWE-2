package Geometrie;

import java.util.Arrays;

import plotter.Plotter;

public class Sinus extends Form {

    public Sinus(Punkt p1, Punkt p2) {
        punkte = new Punkt[2];
        punkte[0] = p1;
        punkte[1] = p2;
    }

    @Override
    public String toString() {
        return "Sinus [punkte=" + Arrays.toString(punkte) + "]";
    }

    @Override
    public void zeichnen(Plotter plotter) {
        plotter.nextDataSet();

        for (double t = 0; t < 2 * Math.PI; t += 0.01) {
            double x = punkte[0].x + 3 * Math.cos(t) * 2;
            double y = punkte[1].y + 1 * Math.cos(t) * 0;
            plotter.add(x, y);
        }



    }

}
