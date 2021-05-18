
public class Employees {
	

	public static void main(String[] args) { 
	
	String[] employees = new String[3];   // Empty array to save employees' full names

	String[] employee_f_name = {"John", "Sally", "Nathan"} ; // object contains first names

	String[] employee_l_name = {"Adam", "Smith", "John"};  // object to stores last name
	
	for  (String firstname : employee_f_name) {
		System.out.println(firstname);
	}
	for  (String lastname : employee_l_name) {
		System.out.println(lastname);
	}
	
	
	
	// After iteration, employees Array should be  
	// ["John Adam", "Sally Smith", "Nathan John"]
	}
	
}
