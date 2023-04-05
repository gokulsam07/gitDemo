package packages.restassured.training;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.path.xml.*;
import io.restassured.response.Response;

public class XMLPathDemo {

	// Approach1 -- no storage
	// @Test(priority=1)
	void app1() {
		given().when().get("http://restapi.adequateshop.com/api/Traveler?page=2").then().statusCode(200)
				.header("Content-Type", "application/xml; charset=utf-8")
				.body("TravelerinformationResponse.page", equalTo("2"))
				.body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("ASCAS"));
	}

	// store the variable and perform deeper validations
	// @Test(priority=2) //same as above but verified using Response variable
	void app2() {
		Response res = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=2");
		Assert.assertEquals(res.statusCode(), 200);
		Assert.assertEquals(res.contentType(), "application/xml; charset=utf-8");
		String pg = res.xmlPath().get("TravelerinformationResponse.page").toString();
		Assert.assertEquals(pg, "2");
		String tname = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name")
				.toString();
		Assert.assertEquals(tname, "ASCAS");
	}

	@Test(priority = 1) // Complex XML validation
	void app3() {
		Response res = given().when().get("http://restapi.adequateshop.com/api/Traveler?page=2");

		XmlPath x = new XmlPath(res.asString());
		List<String> tls = x.getList("TravelerinformationResponse.travelers.Travelerinformation");
		int s = tls.size();
		Assert.assertEquals(s, 10);
		List<String> tlnm = x.getList("TravelerinformationResponse.travelers.Travelerinformation.email");
		boolean status = false;
		for (String mail : tlnm) {
			//System.out.println(mail);
			if (mail.equals("mirza@gmail.com")) {
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);

	}
}
