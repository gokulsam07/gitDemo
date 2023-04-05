package pkg.parent;

public class helloworld {

	public static void main(String[] args) {
//		String val1 = "Personal"; // using string literal    
//		System.out.println(val1); // Personal
//
//		String val2 = new String("Computer"); // using new keyword
//		System.out.println(val2);// Computer


		StringBuffer ob = new StringBuffer(3); //Initialising the StringBuffer capacity to the 15 bytes
  ob.append("Google");
ob.replace(1,3,"bb");
  System.out.println(ob);
  CharSequence seq ="Scaler";
			    System.out.println(ob.capacity());
			    //System.out.println(str1.hashCode());
			  //  System.out.println(str2.isEmpty()); // true
			    
			    int[] array = {1,2,4,5};
			    for(int a:array) {
			    System.out.println(a);}

			  }



//		String val3 = val1 + val2;  // concatenation of strings
//		System.out.println(val3);// Personal Computer



}
