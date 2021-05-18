package Removing;
import java.util.*;
public class RemovingElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list=new LinkedList<String>();

	      //Adding elements to the Linked list
	      list.add("Patrick");
	      list.add("Theodore");
	      list.add("Pijuan");
	      list.add("Rick");
	      list.add("Marty");

	      //Removing First element
	      //Same as list.remove(0);
	      list.removeFirst();

	      //Removing Last element
	      list.removeLast();

	      //Iterating LinkedList
	      Iterator<String> iterator=list.iterator();
	      while(iterator.hasNext()){
	         System.out.print(iterator.next()+" ");
	      }

	      //removing 2nd element, index starts with 0
	      list.remove(1);

	      System.out.print("\nAfter removing second element: ");
	      //Iterating LinkedList again
	      Iterator<String> iterator2=list.iterator();
	      while(iterator2.hasNext()){
	         System.out.print(iterator2.next()+" ");
	      }
	}

}
