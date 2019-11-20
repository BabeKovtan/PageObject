import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import pages.AbstractPage;
import pages.ConstantVariable;

public class BaseTest {

    @BeforeMethod
    public void setup() {
        DriverSingleton.getDriver().get(ConstantVariable.URl);
    }


    @AfterMethod
    public void tearDown() {
        DriverSingleton.closeWebBrowser();
    }
}
