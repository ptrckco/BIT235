import java.util.Scanner;
public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputWindow = new Scanner (System.in);
		System.out.println("Enter the first number");
		int number = inputWindow.nextInt();
		
		if (number < 1 || number > 24) {
			System.out.println("Only Input Number Between 1 and 24");
		} else {
			if (number < 18) {
				System.out.println("Good day!");
			} 
			else {
				System.out.println("Good evening!");
			}
		}
	}

}
