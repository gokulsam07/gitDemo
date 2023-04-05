package learning;

import java.util.regex.Pattern;

public class PatternDemo {

	public static void main(String[] args) {
		boolean isMactched = Pattern.matches(".*Gokul.*", "My name is Gokul");
		System.out.println(isMactched);
		 isMactched = Pattern.matches("[Jj]ava", "java");
		 System.out.println(isMactched);
		 isMactched = Pattern.matches("Pyth[io]n", "Pythen");
		 System.out.println(isMactched);
		 isMactched = Pattern.matches(".ava", "(ava"); //true
		 System.out.println(isMactched);
		 isMactched = Pattern.matches(".*ava", "N^B^#& ^#*(ava"); //true
		 System.out.println(isMactched);
	}
}
