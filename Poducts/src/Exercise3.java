import java.util.Scanner;
public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double pi = 3.14, area;
		Scanner inputWindows = new Scanner (System.in);
		System.out.print("Enter radius of cricle");
		double radius = inputWindows.nextDouble();
		area = pi * (Math.pow(radius,2));
		System.out.println("Area of circle is " + area);

	}

}
