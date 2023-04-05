package learn.automation.online;

import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ReqSpecificationDemo {

	RequestSpecification rs;  //why above the test method? to use it in all test methods
	@BeforeTest // why before test ? to run it before it starts executing the test method
	void setReqSpec() { //why baseUri & base path declared common to class? to use it in all test methods and reduced code re-usability
		rs=given().baseUri("https://reqres.in/api/").basePath("/users");
		RestAssured.requestSpecification =rs;
		//rs=with().baseUri("https://reqres.in/api/").basePath("/employees"); -- no difference b/w given and with -- just syntactical
		//will return the same output/response
	}
	@Test(priority=1)
	void reqDemo() {
		
		given().spec(rs).when().get("/2").prettyPrint();
		System.out.println("With spec method");
	
	}
	@Test(priority=2) //same priority or no priority will be executed in alphabetical order
	void emptyMethodDemo() {
		given().when().get("/2").prettyPrint(); /*no spec mentioned here still it will 
												show result because rs is set as default reqSpec in the class*/	
	System.out.println("Without spec method/but used default spec throughout class");
	}
	
	@Test(priority=3)
	void overrideDemo() {
		RequestSpecification rs1 = given().basePath("/users").baseUri("https://reqres.in/api/");
		given().spec(rs1).when().get("/3").prettyPrint();
		System.out.println("Overrides the default spec method at class level, since it is explicitly mentioned to use rs in test method");
	}
	@Test(priority=4)
	void reqSpecBuiler() {
		RequestSpecBuilder spb = new RequestSpecBuilder();
		spb.setBaseUri("https://reqres.in/api/").setBasePath("/users");
		RequestSpecification res = spb.build();
		given(res).when().get("/4").prettyPrint();
		System.out.println("Print using Req Spec builder type1");
		
		//or
//		RequestSpecification res1 = spb.setBaseUri("https://reqres.in/api/").setBasePath("/users").build();
//		given(res1).when().get("/8").prettyPrint();
//		
//		System.out.println("Print using Req Spec builder type 2");
		
	}

}
