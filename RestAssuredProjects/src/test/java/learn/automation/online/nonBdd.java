package learn.automation.online;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class nonBdd {

	@Test(priority=1)
	void getPetStoreUsers() {
		RestAssured.baseURI = "https://petstore.swagger.io/";
		RequestSpecification rs = RestAssured.given().queryParam("status", "available");
		Response res =rs.request(Method.GET,"v2/pet/findByStatus");
		Assert.assertEquals(res.getStatusCode(), 200);
		//System.out.println(res.prettyPrint());
	}
	
	@Test(priority=2)
	void createUser() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		RequestSpecification rs1 = RestAssured.given().pathParam("pet", "pet").header("Content-type", "application/json")
				.body("{\r\n"
						+ "  \"id\": 894,\r\n"
						+ "  \"category\": {\r\n"
						+ "    \"id\": 43,\r\n"
						+ "    \"name\": \"Labire\"\r\n"
						+ "  },\r\n"
						+ "  \"name\": \"Simbhaa\",\r\n"
						+ "  \"photoUrls\": [\r\n"
						+ "    \"string\"\r\n"
						+ "  ],\r\n"
						+ "  \"tags\": [\r\n"
						+ "    {\r\n"
						+ "      \"id\": 213,\r\n"
						+ "      \"name\": \"breeds\"\r\n"
						+ "    }\r\n"
						+ "  ],\r\n"
						+ "  \"status\": \"available\"\r\n"
						+ "}");
		Response res = rs1.request(Method.POST, "/v2/{pet}");
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println(res.prettyPrint());
	}
	@Test(priority=3)
	void updatePet() {
		RestAssured.baseURI = "https://petstore.swagger.io";
		RequestSpecification rs2 =RestAssured.given().header("Content-Type","application/json").pathParams("pet","pet").body("{\r\n"
				+ "  \"id\": 894,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 43,\r\n"
				+ "    \"name\": \"LabireUpdated\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"Simbhaa\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 213,\r\n"
				+ "      \"name\": \"breeds\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}");
		
		Response res = rs2.request(Method.PUT,"/v2/{pet}");
		System.out.println(res.statusCode());
		System.out.println(res.asPrettyString());
	}
	@Test(priority=4)
	void deletPet() {
		int id = 894;
		RestAssured.baseURI = "https://petstore.swagger.io";
		RequestSpecification rs3 = RestAssured.given().pathParam("pet", "pet");
		Response res = rs3.request(Method.DELETE,"/v2/{pet}/"+id);
		System.out.println(res.statusCode());
		System.out.println(res.asPrettyString());
	}
}
