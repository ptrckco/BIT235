import java.util.Scanner;
public class Exercise5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double sun = 865000, s;
		double earth = 7600, e;
		double pi = 3.14;
		s = Math.pow(sun, 3);
		System.out.println("The cubeic miles of earth is " + s);
		e = Math.pow(earth, 3);
		System.out.println("The cubeic miles of sun is " + e);
		double i = sun/2;
		double b = earth/2;
		double x = 4.0/3.0 * pi * Math.pow(i,3.0);
		System.out.println("The ratio of the sun is" + x);
		double u = 4.0/3.0 * pi * Math.pow(b,3.0);
		System.out.println("The ratio of the earth is " + u);


		
	}

}
