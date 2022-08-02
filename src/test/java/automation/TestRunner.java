package automation;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports"},
        features = "src/test/resources/automation/features",
        glue = {"classpath:steps"}
)
public class TestRunner {
    //Added for Cucumber's use only
    @Test
    public void placeholderTest(){}
}
