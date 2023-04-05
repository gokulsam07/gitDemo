package learn.automation.online;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
public class ConfigurationDemo {
	@Test(enabled=false)
	void DefaultConfig() throws InvalidJsonException, IOException {
		InputStream jsonFile = new FileInputStream("C:\\Users\\v-gokulsam\\Downloads\\medic.json"); //why not file? read below comment
		Configuration con = Configuration.defaultConfiguration();
		//con=con.addOptions(Option.ALWAYS_RETURN_LIST);
		HashMap<String,Object> l = JsonPath.using(con).parse(jsonFile).read("$.medications[9]");
		System.out.println(l);
	}
@Test
	void NULLConfig() throws InvalidJsonException, IOException {
		InputStream jsonFile = new FileInputStream("C:\\Users\\v-gokulsam\\Downloads\\books.json"); //why not file? read below comment
//		Configuration con = Configuration.defaultConfiguration();
//		con=con.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL); -- returns null if value is not present
	//	con=con.addOptions(Option.SUPPRESS_EXCEPTIONS); -- returns null if there is any exception
	//	con=con.addOptions(Option.ALWAYS_RETURN_LIST); -- returns as list though it is string or int (should be stored in List)
	//	con=con.addOptions(Option.REQUIRE_PROPERTIES);		-- validates is all the json have the particular key throughout -- only when indefinite path is used
		Configuration con1 =  Configuration.builder().options(Option.REQUIRE_PROPERTIES).build(); //second way of configuring in one line
		List<HashMap<String,Object>> l = JsonPath.using(con1).parse(jsonFile).read("$.store.book[*].isbn"); //will throw exception at index 0 because there is no isbn for book index 0 
		System.out.println(l);
	}
}
