package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.ConstantVariable;

public class DriverSingleton {

    private static WebDriver driver;
    private DriverSingleton(){

    }

    public static WebDriver getDriver(){
        if (driver==null) {
            createDriver(ConstantVariable.browserName);
        }
        return driver;
    }
    private static  WebDriver createDriver(String browserName){

        if(driver==null){
            if (browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "D://ChromeDriver/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("IE")) {
                System.setProperty("webdriver.edge.driver", "WebDriver.exe");
                driver = new EdgeDriver();
            }
        }
        driver.manage().window().maximize();

        return driver;
        }

    public static void closeWebBrowser() {
        if (null != driver) {
            driver.quit();
        }
        driver = null;
    }
}

