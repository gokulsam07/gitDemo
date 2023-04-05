package packages.restassured.training;
import static io.restassured.RestAssured.*;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;



public class JSONResponseValidation {

	//@Test(priority=1) //Approach 1 -- for loop and conditional statements can't be performed. Only basic validations can be done
	void testApproach1() {
		given().contentType(ContentType.JSON)
		.when().get("https://reqres.in/api/users?page=2")
		.then().statusCode(200).body("data[0].first_name",equalTo("Michael"));

	}

	//@Test(priority=2) //Using Response class -- for complex response object validation
	void testApproach2() {
		Response res = given().contentType(ContentType.JSON)
				.when().get("https://reqres.in/api/users?page=2");

		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.getContentType(), "application/json; charset=utf-8");
		String name = res.jsonPath().get("data[0].last_name").toString();
		Assert.assertEquals(name, "Lawson");
	}

	@Test(priority=1) //Complex validation
	void testApproach3() {
		Response req = given().when().get("https://reqres.in/api/users?page=2");
		JSONObject jo = new JSONObject(req.asString());
		boolean status =false;
		for(int i=0;i<jo.getJSONArray("data").length();i++) {
			String ln = jo.getJSONArray("data").getJSONObject(i).get("last_name").toString();
			if(ln.equals("Lawson")) {
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);

	}
}
