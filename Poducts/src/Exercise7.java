import java.util.Scanner;
public class Exercise7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a word: " );
		String word = input.nextLine();
		String substr = word.substring(7,11);
		
		System.out.println("The substing of " + word + "(7,11)" + substr);
		System.out.print("The length of " + substr + "(7,11)" + substr.length());

	}

}
