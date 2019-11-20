package pages;

import driver.DriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

abstract public class AbstractPage {
    public static WebDriver driver;

    public AbstractPage() {

        driver = DriverSingleton.getDriver();
        getWait().until(webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));
        PageFactory.initElements(driver, this);
    }
    WebDriverWait getWait(){
        return(new WebDriverWait(driver,40));
    }
    WebElement getFluentWait(WebElement webElement){
        //reloadWait(driver);
        setWait(driver);
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
        return (WebElement) wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public static void reloadWait(WebDriver webDriver){
        webDriver.manage().timeouts().pageLoadTimeout(30, SECONDS);
    }

     public static void setWait(WebDriver webDriver){
        webDriver.manage().timeouts().implicitlyWait(45, SECONDS);
     }
      public WebElement waitVisible(WebElement webElement){

            setWait(driver);
          return getWait().until(ExpectedConditions.visibilityOf(webElement));

      }

    public WebElement waitClickable(WebElement webElement){
        setWait(driver);
        return getWait().until(ExpectedConditions.elementToBeClickable(webElement));

    }


}
