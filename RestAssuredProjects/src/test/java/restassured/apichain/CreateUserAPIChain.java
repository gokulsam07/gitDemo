package restassured.apichain;

import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;


public class CreateUserAPIChain {

	@Test
	void createUser(ITestContext context) {

		Faker f = new Faker();
		JSONObject js = new JSONObject();
		js.put("name", f.name().fullName());
		js.put("email", f.internet().emailAddress());
		js.put("gender", "Male");
		js.put("status", "inactive");
		String bt = "3c281bb13a813713a716cd0617a65fa1253daff34e49d1b92ed6824df0b7d2e8";

		int id = given()
				.headers("Authorization", "Bearer " + bt)
				.contentType("application/json")
				.body(js.toString())
			.when()
			.post("https://gorest.co.in/public/v2/users").jsonPath().getInt("id");

		context.getSuite().setAttribute("usrid", id); //to set variable at suite level
		//	context.setAttribute("usrid", id); -- this variable is available only at test level
		
		//if variable is available at suite level, then automatically test level tests will run if we refer them
		//vice versa is not possible -- like global and local variable
		
		System.out.println(id);
	}
}
