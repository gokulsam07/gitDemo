package automation.testng;

import org.testng.annotations.Test;

public class OrderofExecutionDemo {

	
	@Test (priority=1)public void order() {
		System.out.println("Case 2");
	}
	@Test(priority=2) public void order1() {
		System.out.println("Case 3");
	}
	@Test(priority=3) public void order2() {
		System.out.println("Case 4");
	}	@Test(priority=0) public void order3() {
		System.out.println("Case 1");
	}
}
