package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/main/resources/Feature/TranAsn.feature"}, glue= {"StepDefinition"} ,plugin = {"pretty","html:target/cucumber-html/report.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},monochrome=true)

public class TestTranAsn {

}
