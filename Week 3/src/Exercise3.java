import java.util.Scanner;
public class Exercise3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputWindow = new Scanner (System.in);
		System.out.println("Enter a number: ");
		int number = inputWindow.nextInt();
		
		if (number <= 9) {
		System.out.println("This is the number less than 9 is " + number);
		}
		else {
			if (number >= 10 && number <= 54) {
				System.out.println((char)('A' + ((number) - 10)) + " for " + number);
			}
			else {
				if (number >= 55) {
					System.out.println((char)('a' + ((number) - 55)));
					//System.out.println("You've got: " + ((char)(number+55)));

				}
			}
		}
	}

}
