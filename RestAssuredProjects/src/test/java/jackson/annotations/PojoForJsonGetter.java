package jackson.annotations;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;


@JsonPropertyOrder(alphabetic=true) //orders in alphabetic order -- the results of JSON not variable name (if JSONGetter is used)
//@JsonPropertyOrder({"id","email","name","location"}) //  orders as mentioned
public class PojoForJsonGetter {
//@JsonGetter(value="employeeId") //will return employeeId in JSON instead of id
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
	
		public List<String> getSkills() {
			return skills;
		}
		public void setSkills(List<String> skills) {
			this.skills = skills;
		}

//		@JsonValue // will override the default methods inside POJO for serialization and use this one 
//		public String useThisForJsonValue() {
//			return this.email +" " + this.id;	}

		//@JsonGetter  -- not allowed in this location -- use only above the necessary GetMethod()
		String id;
		String name;
		String email;
		String location;
		//@JsonRawValue //simply returns the value inside the list instead of String
		List<String> skills;
	

	}


