package automation.shop.common.pages;

import automation.StepDefinition;
import automation.drivers.Driver;
import automation.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

@Component
public class CommonPage {

    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver,Constants.WAIT_TIME);
    public CommonPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void waitForElementOnPageToBeVisible(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickElementOnPage(WebElement element){
        waitForElementOnPageToBeVisible(element);
        element.click();
    }

    public void goToWebsite(){
        driver.get(Constants.BASE_URL);
    }
}
