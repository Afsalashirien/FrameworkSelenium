package Cucumber.test;
//testing
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = "src/test/java/Cucumber" , glue ="StepDefinitions.test" , 
monochrome = true , plugin = {"html:target/cucumber.html"},tags="@incorrectusernamevalidation")

public class TestNGTestRunner extends AbstractTestNGCucumberTests{

}
