import java.util.Scanner;
public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputWindow = new Scanner (System.in);
		System.out.println("Enter the first number");
		int first = inputWindow.nextInt();
		int total = first*9/5 + 32;
		System.out.println("The Fahrenheit is " + total);
	}

}
