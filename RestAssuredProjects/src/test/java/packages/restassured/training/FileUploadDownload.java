package packages.restassured.training;

import static io.restassured.RestAssured.*;
import java.io.File;

import org.testng.annotations.Test;

public class FileUploadDownload {

	// Uploading single file
	 @Test(priority=1)
	void singleFile() {
		File f = new File("C:\\Users\\v-gokulsam\\Documents\\file.text");
		given().multiPart("file", f).contentType("multipart/form-data").when()
				.post("https://the-internet.herokuapp.com/upload").then().statusCode(200);

	}

	//@Test(priority = 1) //Multiple files -- simply add multipath twice and mention the file
	void MultipleFiles() {
		File f = new File("C:\\Users\\v-gokulsam\\Documents\\file.text");
		File f1 = new File("C:\\Users\\v-gokulsam\\Documents\\file2.text");
		given().multiPart("files", f).multiPart("files", f1).contentType("multipart/form-data").when()
				.post("https://the-internet.herokuapp.com/upload").then().statusCode(200);
		
		
		//array upload using array
//		File f = new File("C:\\Users\\v-gokulsam\\Documents\\file.text");
//		File f1 = new File("C:\\Users\\v-gokulsam\\Documents\\file2.text");
//		File[] far = {f1,f};
//		given().multiPart("files", far).contentType("multipart/form-data").when()
//				.post("https://the-internet.herokuapp.com/upload").then().statusCode(200);

	}
	
	@Test(priority=1) //Download files 
	void dwnld() {
		given().when()
				.get("https://the-internet.herokuapp.com/download/file.text")
				.then().log().all();
	}
}
