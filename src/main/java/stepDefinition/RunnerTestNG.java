package stepDefinition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/main/resources/features/LetsCart.feature",
        monochrome = true
        ,plugin= {"html:target/cucumber.html","json:target/cucumber.json"},
        glue = "stepDefinition",
        tags = "@BaseFlow"
)

public class RunnerTestNG extends AbstractTestNGCucumberTests
{

}
