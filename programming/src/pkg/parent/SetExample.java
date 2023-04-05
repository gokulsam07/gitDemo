package pkg.parent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

	public static void main(String[] args) {
		Set<Integer> s = new HashSet<Integer>();
		
		s.add(0);
		s.add(1);
	System.out.println("Print individual addition "+ s);
	
	//adding an array to set
	
	s.addAll(Arrays.asList(2,3,4,5,6)); 
	//or s.addAll(Arrays.asList(new Integer[] {2,3,4,5,6}));
		
	System.out.println("After array as list " + s);
	
	//Checking if the set contains the element
	
	
System.out.println("Check element "+ s.contains(0));
System.out.println("Check element //non exisiting "+ s.contains(9));
	
	
	 s.addAll(Arrays.asList(new Integer[] {10,11,12,13,14}));
	 s.remove(11);
	 
	 System.out.println("Remove 11 "+ s);
	 
	 TreeSet<String> ts = new TreeSet<String>();
	 
	 ts.add("India");
	 ts.add("Aus");
	 ts.add("Zim");
	 ts.add("Bulgaria");
	// ts.add("India"); allows in compile/run time but in actuality the value doesn't get stored in the set
	 
	 System.out.println("Print tree set in order" + ts);
	 
	 //iteration thru sorted set
	 
	 for(String ss : ts) {
		 System.out.println(ss);
		 System.out.println(" ");
	 }

	 
	 //via iterator class
	 Iterator it = ts.iterator();
	 System.out.println("Via Iterator");
	 while(it.hasNext()) {
		 System.out.println(it.next());
	 }
	 
	Object[] a = ts.toArray();
	
	System.out.println("To Array to print");
	
for(Object v : a) {
	System.out.println(v);
}

ts.removeAll(ts);
System.out.println(ts);
	 
	}

}
