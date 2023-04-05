package jackson.annotations;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class MapPojoExample {

	private Map<String,Object> employee;

	//@JsonAnyGetter -- if we use this annotation in the result only the root values will be displayed
	
	/*
	 * without the annotation the result will be like {
  "employee" : {
    "skills" : [ "Java", "Selenium" ],
    "name" : "Gokul",
    "id" : "EMP_1132",
    "email" : "gokul@gmail.com"
  }
}
	 * 
	 * with the annotation the result will be like
	 * 
	 * {
  "skills" : [ "Java", "Selenium" ],
  "name" : "Gokul",
  "id" : "EMP_1132",
  "email" : "gokul@gmail.com"
}
	 */
	
	
	
	
	
	@JsonAnyGetter
	public Map<String, Object> getEmployee() {
		return employee;
	}

	public void setEmployee(Map<String, Object> employee) {
		this.employee = employee;
	}
}
