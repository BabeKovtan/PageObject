package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;



public class AboutPage extends AbstractPage {
    @FindBy(css = "button.gm-control-active.gm-fullscreen-control")
    WebElement countries;
    @FindBy(css="ul.countries-list")
    List<WebElement> epamsCountries;
    @FindBy(css="ul.cities-list")
    List<WebElement> epamsCities;


    public   List<Integer> getCitiesCount(){
        List<Integer> amountOfCities= new ArrayList<>();
        setWait(driver);
        Actions actions = new Actions(driver);
       //actions.sendKeys(Keys.ARROW_DOWN).perform();

        actions.moveToElement(countries).perform();
        setWait(driver);
        try {
            for (int i = 0; i < epamsCountries.size(); i++) {
                setWait(driver);
                getFluentWait(epamsCountries.get(i)).click();

                amountOfCities.add(epamsCities.size());
                setWait(driver);
                System.out.println(amountOfCities.toString());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return amountOfCities;
    }
}
