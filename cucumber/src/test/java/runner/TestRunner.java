package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",glue="stepdefinitions",plugin= {"pretty","html:report.html","json:report.json","junit:report.xml"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
