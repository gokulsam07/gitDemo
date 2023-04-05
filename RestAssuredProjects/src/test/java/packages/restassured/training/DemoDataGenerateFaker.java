package packages.restassured.training;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;


public class DemoDataGenerateFaker {
@Test
void fakerDemo() {
	Faker f = new Faker();
	

		String a = f.name().fullName();
		String b = f.internet().emailAddress();
		String c = f.address().fullAddress();
		String d = f.phoneNumber().cellPhone();
		String e = f.internet().avatar();


	
	System.out.println("Fullname: "+a);
	System.out.println("email: "+b);
	System.out.println("address: "+c);
	System.out.println("phone: "+d);
	System.out.println("avatar: "+e);
}

}
