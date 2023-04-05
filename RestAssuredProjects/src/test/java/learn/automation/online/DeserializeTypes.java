package learn.automation.online;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import io.restassured.common.mapper.TypeRef;



public class DeserializeTypes {
	@Test(enabled=false)
	void ObjMapperMethod() throws JsonMappingException, JsonProcessingException {
		String json = "{\r\n"
				+ "  \"name\" : \"Gokul\",\r\n"
				+ "  \"location\" : \"India\",\r\n"
				+ "  \"phone\" : \"123456\",\r\n"
				+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
				+ "}";

		ObjectMapper mapper = new ObjectMapper();
		PojoData result = mapper.readValue(json,PojoData.class);
		System.out.println(result.getName());
		System.out.println(result.getLocation());
		System.out.println(result.getPhone());
		System.out.println(result.getCourses()[1]);
	}


	@Test(enabled=false)
	void jsonJaywayMethod() throws IOException {
		File f = new File("C:\\Users\\v-gokulsam\\Downloads\\pojo.json");
		JacksonMappingProvider mp = new JacksonMappingProvider();
		Configuration con = Configuration.builder().mappingProvider(mp).build();
		PojoData obj = JsonPath.using(con).parse(f).read("$",PojoData.class);
		System.out.println(obj.getName());
		System.out.println(obj.getLocation());
		System.out.println(obj.getPhone());
		System.out.println(obj.getCourses()[1]);

	}
	@Test(enabled=false)
	void restJsonPath() {
		File f = new File("C:\\Users\\v-gokulsam\\Downloads\\pojo.json");
		io.restassured.path.json.JsonPath jsonR = io.restassured.path.json.JsonPath.from(f);
		PojoData obj1= 	jsonR.getObject("$", PojoData.class);
		//PojoData obj1= 	jsonR.getObject("", PojoData.class); //empty string or $ both deserialize the full json
		System.out.println(obj1.getName());
		System.out.println(obj1.getLocation());
		System.out.println(obj1.getPhone());
		System.out.println(obj1.getCourses()[1]);
	}
	@Test
	void usingRestFunction() {
		HashMap<String,String> map = given().baseUri("http://restapi.adequateshop.com/api/").when().get("Customer/212999")
		.then().extract().body().as(new TypeRef<HashMap<String,String>>() {
		});
		
		System.out.println(map);
		
		System.out.println(map.get("name"));
		System.out.println(map.get("location"));
		System.out.println(map.get("id"));
		System.out.println(map.get("email"));
		
	}
}
