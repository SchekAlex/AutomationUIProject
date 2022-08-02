package automation.shop.steps;

import automation.StepDefinition;
import cucumber.api.java.en.Given;

public class CommonSteps extends StepDefinition {
    @Given("^I go to the website")
    public void i_go_to_the_website(){
        commonPage.goToWebsite();
    }
}
