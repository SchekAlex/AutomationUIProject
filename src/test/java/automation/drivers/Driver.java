package automation.drivers;

import automation.drivers.strategies.DriverStrategy;
import automation.drivers.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private static Driver instance = null;

    private static WebDriver driver;

    private Driver(String driver){
        instantiate(driver);
    }

    public WebDriver instantiate(String strategy){
        DriverStrategy driverStrategy = DriverStrategyImplementer.chooseStrategy(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static Driver getInstance(String driver) {
        if(instance ==null){
            instance = new Driver(driver);
        }
        return instance;
    }

    public static void closeObjectInstance(){
        instance = null;
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
