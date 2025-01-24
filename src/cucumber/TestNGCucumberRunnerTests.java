package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\Jayashri_Mannur\\workspace\\TestProject\\src\\cucumber\\",glue = "cucumber",
monochrome=true,tags="@ErrorValidation",plugin= {"html:target\\cucumber.html"})
public class TestNGCucumberRunnerTests extends AbstractTestNGCucumberTests{

	
	
}
