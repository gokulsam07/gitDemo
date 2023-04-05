package packages.restassured.training;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.Map;


public class CookieHeaderParams {
	
	//URL --- https://reqres.in/api/users?page=2&id=5
	
	//@Test
	void methodQuery_Path() {
		given()
			.pathParam("myPath", "users")    //path parameter -- use a variable
			.queryParam("page", 2)   //query params -- use exact params
			.queryParam("id", 5)  //query params -- use exact params
		.when()
			.get("https://reqres.in/api/{myPath}")  //query params will be sent along with path params 
		.then()
			.statusCode(200)
			.log().all();
		
	}
	//cookie validation -- cookie value changes everytime. But cookie name remains constant
	//@Test
	void testCookies() {
		Response res = given()
		.when().get("https://google.com");
		
		String cookieRes = res.getCookie("AEC"); //single cookie capture
		System.out.println("Cookie response->"+cookieRes);
	}
	
	//@Test
	void getCookies() {
		Response res = given()
				.when().get("https://google.com");
		
		Map<String, String> cookieRes = res.getCookies(); //multiple cookie capture
		
		
	for(String s: cookieRes.keySet()) {
		String cookie =res.getCookie(s);
		System.out.println(s+ "-"+cookie);
	}	
		
	}
	
	//Header validation - header value is same always 
	
	
	@Test
	void verifyHeader() {
		given().when().get("https://google.com")
		.then().header("Content-Type", "text/html; charset=ISO-8859-1");
		
		
	}
}
