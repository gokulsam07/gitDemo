package automation.testng;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class DependencyDemo {


	@Test (priority=1)
	public void secondarySchool() {
		System.out.println("Secondaryschool");
	}
	
	@Test(priority=2) 
	public void higherSecondary() {
		System.out.println("HigherSecondary"); //this will not run because it is set to false
	}
	
	@Test(priority=3, dependsOnMethods="higherSecondary") 
	public void College() {
		System.out.println("College");
		Assert.assertEquals(true, false);
	}	
	@Test(priority=4,dependsOnMethods="College") 
	public void Masters() {
		System.out.println("Masters"); //will not run /will skip because the College Method is not executed successfully due to false assertion
		
	}
}
