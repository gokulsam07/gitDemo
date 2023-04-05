package packages.restassured.training;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

//Authentication -- valid or not
//Authorization -- only authenticated users will be authorized. Simply access levels

public class AuthTest {

	@Test(priority = 1)
	void basicAuth() {
		RestAssured.baseURI = "https://the-internet.herokuapp.com/";
		
		given().auth().basic("admin", "admin").when().get("basic_auth").then()
				.statusCode(200);
	}

	//@Test(priority = 2)
	void digestAuth() {
		given().auth().digest("postman", "password").when().get("https://postman-echo.com/basic-auth").then()
				.statusCode(200);
	}

	//@Test(priority = 3) // preempitve should be given as preemptive().basic()
	void preemptiveAuth() {
		given().auth().preemptive().basic("postman", "password").when().get("https://postman-echo.com/basic-auth")
				.then().statusCode(200);
	}

	//@Test(priority = 4)
	void bearerAuth() {
		String bearer = "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";
		given().headers("Authorization", "Bearer" + bearer) // Important -- for bearer auth, the syntax is
															// headers("Authorization","Bearer"+varname);
				.when().get("https://github.com").then().statusCode(200);
	}

	//@Test(priority = 5)
	void oAuth2Auth() {
		given().auth().oauth2("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").when().get("https://github.com").then()
				.statusCode(200);
	}
	
	///?lat={lat}&lon={lon}&cnt={cnt}&appid={API key}
	
	//@Test(priority=6)
	void APITest() {
		given()
			.pathParam("myPath", "data/2.5/forecast/daily")
			.queryParam("lat", 10.99)
			.queryParam("lon", 44.34)
			.queryParam("cnt", "IT")
			.queryParam("appid", "fe3cb6a37f0b290289fb8f1c5f110671")
			.when().get("https://api.openweathermap.org/{myPath}")
			.then().log().all();
		
	}
}