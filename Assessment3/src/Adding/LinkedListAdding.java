package Adding;

import java.util.*;


public class LinkedListAdding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	     LinkedList<String> list=new LinkedList<String>();

	     //Adding elements to the Linked list
	     list.add("Patrick");
	     list.add("Theodore");
	     list.add("Pijuan");

	    //Adding an element to the first position
	    list.addFirst("Matthew");
	    //Adding an element to the last position
	    list.addLast("Rick");

	    //Adding an element to the 3rd position
	    list.add(2, "Marvin");

	    //Iterating LinkedList
	    Iterator<String> iterator=list.iterator();
	    while(iterator.hasNext()){
	    System.out.println(iterator.next());
	   }	
	}

}
