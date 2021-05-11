package Geometrie;

public class Punkt {
	double x;
	double y;

	public Punkt(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Punkt [x=" + x + ", y=" + y + "]";
	}

	public void bewegeUm(double dx, double dy) {
		x += dx;
		y += dy;
	}

}
