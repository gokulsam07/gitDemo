package restassured.apichain;

import static io.restassured.RestAssured.given;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUserAPIChain {

	@Test
	void updateList(ITestContext context) {
		Faker f = new Faker();
		JSONObject js = new JSONObject();
		js.put("name", f.name().fullName());
		js.put("email", f.internet().emailAddress());
		js.put("gender", "Female");
		js.put("status", "active");
		String bt = "3c281bb13a813713a716cd0617a65fa1253daff34e49d1b92ed6824df0b7d2e8";
		int id = (Integer) context.getSuite().getAttribute("usrid");
		 given().headers("Authorization", "Bearer " + bt).contentType("application/json").body(js.toString())
				.pathParam("id", id)
				.when().patch("https://gorest.co.in/public/v2/users/{id}")
				.then().log().all();
	}
	}
	
