package automation;

import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.Driver;
import automation.shop.common.pages.CommonPage;
import automation.shop.pages.HomePage;
import automation.shop.pages.LoginPage;
import automation.shop.steps.LoginSteps;
import automation.utils.Constants;
import automation.utils.Utils;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


public class StepDefinition {

    private WebDriver driver;

    @Autowired
    protected Utils utils;
    @Autowired
    protected HomePage homePage;
    @Autowired
    protected LoginPage loginPage;
    @Autowired
    protected CommonPage commonPage;

    @Before
    public void beforeMethod(){
        Driver.getInstance(utils.getProperty(Constants.CHROME));
        driver = Driver.getDriver();
    }
}
