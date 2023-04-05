package learn.automation.online;
import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;
import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;


public class PredicateDemo {
	File f = new File("C:\\Users\\v-gokulsam\\Downloads\\books.json");
	
	@Test
	void InlinePredicate() throws IOException {
		List<String> l = JsonPath.parse(f).read("$.store.book[?(!(@.price<10 && @.category =='fiction'))]");
		
		//Jayway json path reference link ----https://github.com/json-path/JsonPath
		/*conditional predicate examples
		 * AND --"$.store.book[?(@.price>8 && category=='fiction')].title"
		 * OR --- "$.store.book[?(@.price>8 || category=='reference')].title"
		 * NOT --"$.store.book[?(!(@.price < 10 && @.category == 'fiction'))].title"
		 */
	System.out.println(l);
	}
	@Test(enabled=true)
	void filterPredicate() throws IOException {
		//Filter lessthan10 = Filter.filter(Criteria.where("price").lt(10));
		//Filter and = Filter.filter(Criteria.where("price").lt(10).and("category").is("reference"));
		//Filter and1 = Filter.filter(Criteria.where("isbn").exists(true).and(("price").gt(20)));
		Filter or = Filter.filter(Criteria.where("isbn").exists(true)).or(Criteria.where("price").lt(10));
		
		//List<Object> l = JsonPath.parse(f).read("$.store.book[?]",lessthan10);
		List<HashMap<String,Object>> l = JsonPath.parse(f).read("$.store.book[?]",or); //difference b/w line above and this is -- map will be used to fetch values using index and value
		System.out.println(l);
	}
@Test(enabled=true)
	void userDefinedPredicate() throws IOException {
	
	Predicate userDefinedPredicate = new Predicate() {
	
		public boolean apply(PredicateContext ctx) {
			// TODO Auto-generated method stub
			boolean userDefinedPredicate = ctx.item(Map.class).containsKey("isbn"); //why Map.class? Only map has key -- we can validate if a particular key is present in the JSON object or not
			return userDefinedPredicate;
			
		} //we can use lambdas to shorten the code //learn Java 8
	};
	
	@SuppressWarnings("unchecked")
	List<Map<String,Object>> books = JsonPath.parse(f).read("$.store.book[?]",List.class,userDefinedPredicate); //why List.class ? The filter returns a List type
		System.out.println(books);
	}
}
