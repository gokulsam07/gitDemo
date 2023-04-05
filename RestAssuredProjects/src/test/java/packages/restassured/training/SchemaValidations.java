package packages.restassured.training;
import static io.restassured.RestAssured.*;
import java.io.File;
import org.testng.annotations.Test;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;

public class SchemaValidations {

	
	@Test(priority=1) //Test the JSON schema -- json file (.json) --> json schema (.json)
	void JSONSchema() {
		File f = new File("C:\\Users\\v-gokulsam\\Downloads\\data.json");
		given()
		.when().get("http://restapi.adequateshop.com/api/Customer")
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchema(f));
	}
	
	@Test(priority=2) //Test the JSON schema -- xml file (.json) --> xml schema (.xsd)
     void XMLSchema() {
		File f = new File("C:\\Users\\v-gokulsam\\Downloads\\definition.xsd");
		given()
		.when().get("http://restapi.adequateshop.com/api/Traveler?page=2")
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsd(f)); 
		
	
		//there is no inbuilt xml validator like json validator in rest assured, so use restAssuredMatchers
				
	}

}

