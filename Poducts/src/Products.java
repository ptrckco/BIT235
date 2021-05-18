import java.util.Scanner;
public class Products {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputWindow = new Scanner (System.in);
		System.out.println("Enter the first number");
		int first = inputWindow.nextInt();
		System.out.println("Enter second number");
		int second = inputWindow.nextInt();
		int total = first - second;
		System.out.println("The difference of the two numbers is " + total);
	}

}