
public class Exercise6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		normal();
		rough();
	}
		static void normal() {
			double ltNormal = 8*100;
			int Fullliter = 40;
			double consumption = (Fullliter/ltNormal) * 100;
			
			System.out.println("The consumed fuel on normal road is " + consumption + "Lt/Km");
	}
		static void rough() {
			double ltRough = 9.2*100;
			int Fullliter = 40;
			double consumption = (Fullliter/ltRough) * 100;
			
			System.out.println("The consumed fuel on rough road is " + consumption + "Lt/Km");
	}
}
