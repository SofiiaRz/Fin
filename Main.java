package yahoo.sofiia.riazanova;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle triangleOne = new Triangle(6.3, 5.4, 6.5);
		if (checkExist(triangleOne) == true) {
			System.out.println("Area of triangle is " + triangleOne.calculateArea());
		} else {
			System.out.println("There is no such triangle.");
		}

		Triangle triangleTwo = new Triangle(3.4, 2.4, 6.5);
		if (checkExist(triangleTwo) == true) {
			System.out.println("Area of triangle is " + triangleTwo.calculateArea());
		} else {
			System.out.println("There is no such triangle.");
		}
	}

	public static boolean checkExist(Triangle triangle) {
		double a = triangle.getSideFirst();
		double b = triangle.getSideSecond();
		double c = triangle.getSideThird();
		if (a + b > c && b + c > a && c + a > b) {
			return true;
		} else {
			return false;
		}
	}
}
