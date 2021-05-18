import java.util.Scanner;
public class Exercise8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first word: ");
		String text1 = input.next();
		System.out.print("Enter second word: ");
		String text2 = input.next();
		char word1 = text1.charAt(0);
		char word2 = text2.charAt(0);
		if (text1.equals(text2)) {
			System.out.println("The two given strings are equal.");
			if (word1 == word2) {
				System.out.print("The firt character of each word form " + text1 + " and " + text2 + " are " + word1 + " and " + word2);
			}
		}
		else {
			System.out.print("Strings are not equal");
		}
		

	}

}
