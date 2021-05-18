import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputWindow = new Scanner(System.in);
		System.out.println("Enter first number: ");
		int num1 = inputWindow.nextInt();
		
		System.out.println("Enter second number: ");
		int num2 = inputWindow.nextInt();
		
		System.out.println("Enter third number: ");
		int num3 = inputWindow.nextInt();
		
		Integer[] arr = new Integer[3];
		arr[0] = num1;
		arr[1] = num2;
		arr[2] = num3;
		Arrays.sort(arr);
		System.out.println("Non descending order: ");
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
	}

}
