package jackson.annotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAnnotationsDemo {

	@Test(enabled=false)
	void testJsonAnyGetter() throws JsonProcessingException {
		MapPojoExample mapPojo = new MapPojoExample();
		Map<String,Object> values = new HashMap<String,Object>();
		values.put("id", "EMP_1132");
		values.put("name", "Gokul");
		values.put("email", "gokul@gmail.com");
		values.put("skills", Arrays.asList("Java","Selenium"));
		mapPojo.setEmployee(values);
		ObjectMapper mapper = new ObjectMapper();
		String s  = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapPojo);
		
		System.out.println(s);
		
	}
	@Test(enabled=false)
	void JsonGetter() throws JsonProcessingException { //for property order as well
		PojoForJsonGetter pjg = new PojoForJsonGetter();
		pjg.setEmail("gokul@gmail.com");
		pjg.setId("EMP-1134");
		pjg.setLocation("India");
		pjg.setName("Gokul");
		
		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pjg);
		System.out.println(s);
	}
	
	@Test(enabled=true)
	void JsonRawValue() throws JsonProcessingException { 
		PojoForJsonGetter pjg = new PojoForJsonGetter();
		pjg.setEmail("gokul@gmail.com");
		pjg.setId("EMP-1134");
		pjg.setLocation("India");
		pjg.setName("Gokul");
		pjg.setSkills(Arrays.asList("Java","Selenium"));
		
		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pjg);
		System.out.println(s);
	
		
	}
}
