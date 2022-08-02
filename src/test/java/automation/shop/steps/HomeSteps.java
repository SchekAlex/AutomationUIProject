package automation.shop.steps;

import automation.StepDefinition;
import cucumber.api.java.en.When;

public class HomeSteps extends StepDefinition {

    @When("^I click on Sign in Button")
    public void i_click_on_sign_in_button(){
        homePage.clickSignInButton();
    }
}
