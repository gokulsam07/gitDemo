package restassured.apichain;
import static io.restassured.RestAssured.*;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class GetUserAPIChain {
@Test
	void getListUser(ITestContext context) {
		int id = (Integer) context.getSuite().getAttribute("usrid");
		String bt = "3c281bb13a813713a716cd0617a65fa1253daff34e49d1b92ed6824df0b7d2e8";
		
		given()
		.headers("Authorization", "Bearer " + bt)
		.pathParam("id", id)
	.when().get("https://gorest.co.in/public/v2/users/{id}")
		.then().statusCode(200).log().all();
	}

}
