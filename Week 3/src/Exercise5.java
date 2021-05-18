import java.util.Scanner;
public class Exercise5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputWindow = new Scanner (System.in);
		System.out.println("Enter a number: ");
		int number = inputWindow.nextInt();
		
		if (number % 2 == 0) {
			System.out.println(number + " is an Even number.");
		}
		else {
			System.out.println(number + " is an Odd number.");
		} 
	}

}
