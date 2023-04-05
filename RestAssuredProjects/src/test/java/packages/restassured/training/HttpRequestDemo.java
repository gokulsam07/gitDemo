package packages.restassured.training;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;


public class HttpRequestDemo {

	int id;
	@Test(priority=1)
void getUsers() {
	
	given().when().get("https://reqres.in/api/users?page=2").then().statusCode(200).body("page", equalTo(2));
	
}
	@Test(priority=2)
	void createUser() {
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("id", 121);
		hm.put("email", "edi777@gmail.com");
		hm.put("first_name", "Edison");
		hm.put("last_name", "Sub");
		hm.put("avatar", "https://reqres.in/img/faces/7-image.jpg");
		
		 id = given()
		.contentType("application/json")
		.body(hm)
		.when()
		.post("https://reqres.in/api/users")
		.jsonPath().getInt("id");
		}
	
	@Test(priority=3, dependsOnMethods = {"createUser"})
	void updateUser() {
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("email", "edison777@gmail.com");
		hm.put("first_name", "Edison");
		hm.put("last_name", "Subiramani");
		hm.put("avatar", "https://reqres.in/img/faces/7-image.jpg");
		
		given().contentType("application/json").body(hm)
		.when().patch("https://reqres.in/api/users/"+id)
		.then().statusCode(200);
	}
	
	@Test(priority=4)
	void deleteUser() {
		
		when().delete("https://reqres.in/api/users/"+id)
		.then().statusCode(204);
		}

	}





/*
 * given()
 * ---- cookie, content type, params, authentication, headers...
 * 
 * when()
 * ---- get,post, patch, delete...
 * 
 * then()
 *  status code, exact response, exact headers, exact body... 
 * 
 * 
 */