package automation.config;

import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class CucumberConfiguration {
    @Before
    public void setup_cucumber(){}
}
