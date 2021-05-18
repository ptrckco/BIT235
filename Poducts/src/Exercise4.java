import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int P = 5000;
		double r = .04, A;
		Scanner inputWindows = new Scanner (System.in);
		System.out.print("Enter number of years");
		double number = inputWindows.nextDouble();
		
		double i = 1 + r;

		A = P * Math.pow(i, number);
		System.out.println("The calculate the compund interest of " + A);
		
	}

}
