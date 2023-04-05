package pkg.parent;
import java.util.*;

public class ArrayListExample {

	public static void main(String[] args) {
		
		ArrayList<String> al = new ArrayList<String>();
		
		//Commonly used methods -> add, remove, set
		
		//add(Obj) -- adds object at end of list
	  al.add("BMW");
	  al.add("LMW");
	  al.add("CMW");
	  al.add("LMW");
	  
	  System.out.println("After add @ end "+al);
	  
	  //add(index,object) -- adds object at the specified index
	  
	  al.add(0,"AMW");
	  
	  System.out.println("After indexed add"+al);
	  
	  //2. set(index,obj) -- update an element at given index
	  
	  al.set(0, "Update");
	  
	  System.out.println("After indexed update"+al);
	  
	  // Remove an element -- remove(index) -- removes at the specific index of list
	  
	 
	  al.remove(0);
	  System.out.println("After indexed removal"+al);
	  
	  //removes the object remove(object)
	  
	  al.remove("LMW");
	  System.out.println("After random removal" + al);
	  
	  //Iterating
	  System.out.println("For loop iteration");
	  for(int i=0;i<al.size();i++) {
		  System.out.println(al.get(i));
	  }
	  
	  //For each
	  System.out.println("for each");
	  for(String i : al) {
		  System.out.println(i);
	  }


	}

}
