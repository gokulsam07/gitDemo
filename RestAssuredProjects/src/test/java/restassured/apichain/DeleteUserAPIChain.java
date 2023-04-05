package restassured.apichain;
import static io.restassured.RestAssured.*;
import org.testng.ITestContext;
import org.testng.annotations.Test;


public class DeleteUserAPIChain {

	@Test
	void deleteList(ITestContext context) {
		String bt = "3c281bb13a813713a716cd0617a65fa1253daff34e49d1b92ed6824df0b7d2e8";
		int id = (Integer) context.getSuite().getAttribute("usrid");
		given().header("Authorization","Bearer " +bt).contentType("application/json").pathParam("id", id)
		.when().delete("https://gorest.co.in/public/v2/users/{id}")
		.then().log().all().statusCode(204);
	}
}
