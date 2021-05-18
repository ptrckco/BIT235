
public class Exercise4b {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 100;
		System.out.print("All the integers from 1 to "+n+" are: ");
		for (int i = 1; i <= n; i++) {
		   //if number%2 == 0 it means its an even number
		   if (Math.sqrt(i) == (int)Math.sqrt(i)) {
			System.out.println(i);
		   }
		}
	}

}
