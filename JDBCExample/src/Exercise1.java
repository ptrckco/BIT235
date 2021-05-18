import java.util.*;
public class Exercise1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Defining an ArrayList  
		  List<String> list_Strings = new ArrayList<String>();
		  //Adding few elements as colours
		  list_Strings.add("Red");
		  list_Strings.add("Green");
		  list_Strings.add("Orange");
		  list_Strings.add("White");
		  list_Strings.add("Black");
		  //Displaying the ArrayList
		  System.out.println(list_Strings);
		  
		  //adding the first element (Yellow) before red (original first element) and display the result
		  //Update the above code to add the element at the first position in the list (Add “Yellow”)
		  list_Strings.add(0, "Yellow");
		  System.out.println(list_Strings);
		  
		  //Update the above code to retrieve an element (at a index 5) from a given array list
		  System.out.println(list_Strings.get(5));
		  
		  
		  //	Update the above code to remove the third element from a array list and print out the collection
		  list_Strings.remove(2);
		  System.out.println(list_Strings);

//			Update the above code to search an element in a array list (Search for Yellow color)
		  int indexresult =  list_Strings.indexOf("Yellow");
		  System.out.println("Yellow is at index " + indexresult + " in ArrayList");
		  
		  //Update the above code to sort the array list and print the collection
		  Collections.sort(list_Strings);
		  System.out.print("Sorted ArrayList is: ");
		  System.out.println(list_Strings);
	
		 

	}

}
