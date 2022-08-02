package automation.shop.pages;

import automation.drivers.Driver;
import automation.shop.common.pages.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends CommonPage {

    private WebDriver driver;

    public HomePage(){
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='header_user_info']")
    private WebElement signInButton;

    public void clickSignInButton(){
        clickElementOnPage(signInButton);
    }
}
