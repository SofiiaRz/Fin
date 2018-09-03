package yahoo.sofiia.riazanova;

public class Rectangle extends Shape {
	private Point a;
	private Point b;
	private Point c;
	private Point d;

	public Rectangle(Point a, Point b, Point c, Point d) {
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public Rectangle() {
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

	public Point getD() {
		return d;
	}

	public void setD(Point d) {
		this.d = d;
	}

	@Override
	public double calculatePerimetr() {
		return a.calculateDistance(a, b) * 2 + a.calculateDistance(a, c) * 2;
	}

	@Override
	public double calculateArea() {
		return a.calculateDistance(a, b) * a.calculateDistance(a, c);
	}

	@Override
	public String toString() {
		return "Rectangle [a=" + a + ", b=" + b + ", c=" + c + ", d=" + d + "]";
	}

}
