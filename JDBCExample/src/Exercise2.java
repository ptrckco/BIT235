import java.util.*;
public class Exercise2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  // Defining an HashMap  
		  Map<String, String> coloursHash = new HashMap<>();
	  //Adding few elements as colours
		  coloursHash.put ("FF0000","Red");
		  coloursHash.put ("008000","Green");
		  coloursHash.put ("FFA500","Orange");
		  coloursHash.put ("FFFFFF","White");
		  coloursHash.put ("000000","Black");
		//Displaying the Hashmap
		  System.out.println(coloursHash);
		  
		//Update the above program  to count the number of key-value (size) mappings in a map
		  System.out.printf("The size of the HashMap is %d%n", coloursHash.size());

		 //Update the above program to get the value of a specified key in a map
		  System.out.println("The name of color #FFA500 Hex code is : " +   
		  coloursHash.get("FFA500"));
		  
		 //Update the above program to  remove a specific mappings from a map ..REMOVING FFA500 key-value pair
		  coloursHash.remove("FFA500");
		  System.out.println(coloursHash);
		  System.out.printf("After remvoing one key value pair, the size of the HashMap is %d%n ", coloursHash.size());

		  //Update the above program to view of the keys contained in this map - THAT IS LIST OF THE KEYS
		  System.out.print("List of the keys in Hashmap is : ");
		  System.out.println(coloursHash.keySet());
		  
		  // Searching in a key - Optional
		  if (coloursHash.containsKey("000000"))
		      System.out.println("Colours Hash contains key 000000");
		  else 
			  System.out.println("Colours Hash does not contains key 000000");

	}

}
