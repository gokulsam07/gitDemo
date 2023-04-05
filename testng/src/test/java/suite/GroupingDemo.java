package suite;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class GroupingDemo {

	@Test(groups= {"Apple"})
	@Parameters({"what","name"})
	public void Apple1(String x, String y) {
		System.out.println(x + " " + y+" 11");
	}
	@Test(groups= {"Apple"})
	@Parameters("name")
	public void Apple2(String name) {
		System.out.println(name+ " 12ProMax");
	}
	@Test(groups= {"Samsung"})
	public void Samsung1() {
		System.out.println("Samsung Galaxy F12");
	}
	@Test(groups= {"Samsung"})
	public void Samsung2() {
		System.out.println("Samsung Galaxy S12");
	}
	@Test(groups= {"Samsung"})
	public void Samsung3() {
		System.out.println("Samsung Galaxy A19");
	}
	@Test(groups= {"Redmi"})
	public void Redmi1() {
		System.out.println("Redmi 9");
	}
	@Test(groups= {"Redmi"})
	public void Redmi2() {
		System.out.println("Redmi Note 11 pro");
	}
	@Test(groups= {"Redmi"})
	public void Redmi3() {
		System.out.println("Redmi C31");
	}
	@Test(groups= {"Redmi"})
	public void Redmi4() {
		System.out.println("Redmi Ultra pro max");
	}

}
