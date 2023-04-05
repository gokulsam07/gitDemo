package pkg.parent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

public class MapExample {

	public static void main(String[] args) {
		
		Map<Integer, String> m = new HashMap<Integer, String>();
		
		//insert
	m.put(0, "A");
	m.put(1, "B");
	m.put(2, "A");
	m.put(3, "B");
	m.put(4, "A");
	m.put(5, "B");
	
	System.out.println("Addition"  +m);
	
	
	//Update
	
	m.put(2, "C");
	m.put(3, "D");
	
	System.out.println("Updated" + m);
	
	//removal
	
	m.remove(4);
	m.remove(5);
	
	System.out.println("Removal" +m);
	
	//Iterating through tree Map
	
	for(Map.Entry<Integer, String> t : m.entrySet()) {
		System.out.println(t.getKey() + " "
                + t.getValue());
		
	}
		
	
	//using Iterator
	
	Iterator<Map.Entry<Integer, String>> itr = m.entrySet().iterator();
	System.out.println("Print using Iterator");
	while(itr.hasNext()) {
		System.out.println(itr.next());
	}
	

	}

}
