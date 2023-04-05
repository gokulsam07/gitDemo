package learn.automation.online;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathLearnings {

	@Test(enabled = false)//Parses everytime
	void readJsonPath() throws IOException {
		File jsonFile = new File("C:\\Users\\v-gokulsam\\Downloads\\medic.json");
		String res = JsonPath.read(jsonFile, "$.medications[0].aceInhibitors[0].refills");
		HashMap<String,String> resAngi = JsonPath.read(jsonFile, "$.medications[0].antianginal[0]");
		System.out.println(res);
		System.out.println(resAngi);
	}

	@Test(enabled = false)//parse one time
	void readJsonMethod2c() throws IOException {
		InputStream jsonFile = new FileInputStream("C:\\Users\\v-gokulsam\\Downloads\\medic.json"); //why not file? read below comment
		//Configuration.defaultConfiguration().jsonProvider().parse(jsonFile); -- this won't work for file type as it accepts Inputfile stream,String byte
		Object parsedJsonDoc = Configuration.defaultConfiguration().jsonProvider().parse(jsonFile.toString());
		String resInhi = JsonPath.read(parsedJsonDoc, "$.medications[0].aceInhibitors[0].refills");
		String resAngi = JsonPath.read(parsedJsonDoc, "$.medications[0].antianginal[0].refills"); //what's the difference b/w this & above method? using parsed object instead of using the file object
System.out.println(resInhi);
System.out.println(resAngi);
jsonFile.close();//closing the stream
	}

	@Test(enabled=true)//FluentAPI creators say, this is the fastest method to parse -> no way to measure
	void FluentAPIParsing() throws IOException {
		File jsonFile = new File("C:\\Users\\v-gokulsam\\Downloads\\medic.json");
		DocumentContext parsedFile = JsonPath.parse(jsonFile); //storing in document context class is important part of Fluent API
		List<Object> s = parsedFile.read("$.medications[0].antianginal"); //also parsed once and can be read multiple times
		System.out.println(s);
		
//one more way to parse Json using Fluent API		
		Configuration con = Configuration.defaultConfiguration();
		HashMap<String,String> l = JsonPath.using(con).parse(parsedFile).read("$.medications[0]");
		System.out.println(l);
	}
}
