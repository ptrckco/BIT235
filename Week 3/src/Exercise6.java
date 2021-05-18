import java.util.Scanner;
public class Exercise6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner inputWindow = new Scanner (System.in);
		System.out.print("Please enter length: ");
		double length = inputWindow.nextDouble();
		
		System.out.print("Please enter width: ");
		double width = inputWindow.nextDouble();
		
		System.out.print("Please enter color: ");
		String color = inputWindow.next();
		
		System.out.print("Please enter type: ");
		String type = inputWindow.next();
		
		System.out.print("Please enter crown: ");
		int crown = inputWindow.nextInt();
		
		double colorPrice;
		double typePrice;
		double crownPrice = crown * 0.35;
		
		if(color != "white" ) {
			colorPrice = 0.10;
		}
		else {
			colorPrice = 0;
		}
		if (type == "regular") {
			typePrice = 0.15;
		}
		else {
			typePrice = 0.23;
		}
		
		double total = (length * width) * 2 * (colorPrice + typePrice + crownPrice);
		System.out.println("The cost of frame is: " + total);
	}

}
