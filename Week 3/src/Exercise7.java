import java.util.Scanner;
public class Exercise7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int firstNum, secondNum;
		
		do{
	           System.out.print("Input first number: ");
	           firstNum = input.nextInt();
	           System.out.print("Input second number: ");
	           secondNum = input.nextInt();
	           for(int i= firstNum; i <= secondNum; i++){
	               if(i % 2== 1){
	                   System.out.println(i + " ");
	               }
	           }
	           System.out.println();
	           int evenSum = 0;
	           for(int i= firstNum; i <= secondNum; i++){
	               if(i % 2== 0){
	                   System.out.print("" + i + " ");
	                   evenSum += i;
	               }
	           }
	           System.out.println();
	           System.out.println("Sum of even: " + evenSum);
	           System.out.println();
	           int squareOddSum = 0;
	           for(int i= firstNum; i <= secondNum; i++){
	               System.out.println(i + " : " + (i*i) );
	               if(i % 2 ==1){
	                   squareOddSum += i;
	               }
	           }
	           System.out.println();
	           System.out.println("Sum of squared odd number: " + squareOddSum);
	           
	           String str = "Welcome To The World!";
	           for(int i = 0; i < str.length(); i++) {
	        	   if (Character.isUpperCase(str.charAt(i))) {
	        		   System.out.println(str.charAt(i));
	        	   }
	           }
	       }
		while(firstNum < secondNum);
	}

}
