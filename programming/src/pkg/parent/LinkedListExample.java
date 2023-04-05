package pkg.parent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {

	public static void main(String[] args) {

		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("Tom");
		ll.add("Dick");
		ll.add("Harry");
		ll.add(2,"ModifyThruAdd");
		
		System.out.println(ll);
		
		//Add in Front
		
		ll.addFirst("Front");
		ll.set(3, null);
		ll.set(3, "Holy");
		System.out.println(ll);
		
		//Add in back
	ll.addLast("Last");
	for(Object element : ll)
        System.out.print(element+" ");
	
	List<String> li;

	li = new ArrayList<String>();
	li = new LinkedList<String>();
		
		
	}

}
