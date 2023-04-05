package packages.restassured.training;

import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/* Serialization and deserialization 
 *  java object(POJO Class) --> byte stream (platform independent) in this case JSON -- Serialization 
 *  byte stream (platform independent) in this case JSON --> java object(POJO Class) -- Deserialization
 */
public class SerializeDeserialize {

@Test(priority=1)
void serializeTest() throws JsonProcessingException {
	
	PojoData p = new PojoData();  //Java object -- POJO (Plain Old Java Object) -- is also a Java Object
	p.setName("Gokul");
	p.setPhone("123456");
	p.setLocation("India");
	p.setCourses(new String[] {"C","C++"});
	
	
	ObjectMapper o = new ObjectMapper(); //ObjectMapper is used to create an object whose methods converts POJO to JSON
	String jsono = o.writerWithDefaultPrettyPrinter().writeValueAsString(p);
	
	System.out.println(jsono);

}

@Test(priority=2)
void DeserializeTest() throws JsonMappingException, JsonProcessingException {
	
	String s= "{\r\n"
			+ "  \"name\" : \"Gokul\",\r\n"
			+ "  \"location\" : \"India\",\r\n"
			+ "  \"phone\" : \"123456\",\r\n"
			+ "  \"courses\" : [ \"C\", \"C++\" ]\r\n"
			+ "}";
	
	ObjectMapper oj = new ObjectMapper();
	PojoData p = oj.readValue(s, PojoData.class);
	System.out.println(p.getLocation());
	System.out.println(p.getPhone());
	System.out.println(p.getName());
	System.out.println(p.getCourses()[0]);
	System.out.println(p.getCourses()[1]);
	
	
}
}
