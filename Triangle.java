package yahoo.sofiia.riazanova;

public class Triangle extends Shape {
	private Point a;
	private Point b;
	private Point c;

	public Triangle(Point a, Point b, Point c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triangle() {
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	@Override
	public double calculatePerimetr() {
		return a.calculateDistance(a, b) + b.calculateDistance(b, c) + c.calculateDistance(a, c);
	}

	@Override
	public double calculateArea() {
		double halfPrmt = calculatePerimetr() / 2;
		return Math.sqrt(halfPrmt * (halfPrmt - a.calculateDistance(a, b)) * (halfPrmt - b.calculateDistance(b, c))
				* (halfPrmt - c.calculateDistance(a, c)));
	}

	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
	}
}
