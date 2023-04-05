package stepdefinitions;

import java.util.Map;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterTest {
	@Given("when user opens register page")
	public void when_user_opens_register_page() {
		System.out.println("a");
	}

	@When("user enters all the mandatory details")
	public void user_enters_all_the_mandatory_details(DataTable dataTable) {
		Map<String, String> values = dataTable.asMap(String.class,String.class);
		System.out.println("User entered fname "+ values.get("firstName"));
		System.out.println("User entered lname "+ values.get("lastName"));
		System.out.println("User entered email "+ values.get("email"));
		System.out.println("User entered telephone "+ values.get("telephone"));
		System.out.println("User entered password "+ values.get("password"));
		System.out.println("User entered confirm "+ values.get("confirm"));
	}

	
	@When("user selects policy")
	public void user_selects_policy() {
		System.out.println("a");
	}

	@When("user clicks create")
	public void user_clicks_create() {
		System.out.println("a");
		Assert.assertFalse(true);
	}

	@Then("account should be created")
	public void account_should_be_created() {
		
		System.out.println("a");
	}	 
}
