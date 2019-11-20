package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;



public class TrainingListPage extends  AbstractPage{


    WebDriverWait wait=new WebDriverWait(driver, 20);
    @FindBy(name ="training-filter-input")
    WebElement trainingListSearch;
    @FindBy(css = "div.location__not-active-label.city-name.ng-binding.location__location-active-label.location__location-active-label-country" )
    WebElement ukraine ;
    @FindBy(xpath =" //li[@class=\"cities ng-scope\"][last()-1]//label//span//preceding-sibling::input[not(contains(@class, 'our-skills'))]")
    WebElement lviv;
    @FindBy(css= "div.filter-toggle__arrow-icon.arrow-icon-rotate" )
    WebElement arrow;
    @FindBy(xpath = "//div[@class='training-list__container training-list__desktop']//div[@class=\"training-item__location ng-binding\"][contains(text(),'Lviv, Ukraine')]")
    List<WebElement> trainingsLocations ;
    @FindBy(xpath = "//div[contains(text(),'By skills')]" )
    WebElement bySkillsButton ;
    @FindBy(xpath = "//label[contains(.,'Java')]//span")
    WebElement javaCheckbox ;
    @FindBy(xpath = "//div[@class='training-list__container training-list__desktop']//a[@class='training-item__title-link ng-binding']" )
    List<WebElement> skillsSearchResultsList ;
    @FindBy(css = "span.filter-field__input-item-close-icon.filter-field__input-item-close-icon--common")
    WebElement clearSkill;
    @FindBy(xpath = "//label[contains(.,'Data')]//input[contains(@class,\"our-skills\")]//following-sibling::span")
    List<WebElement> dataCheckbox ;
    @FindBy(className = "filter-toggle__arrow-icon")
    WebElement expandSkillsArrow;

    public TrainingListPage searchTraining(){
        trainingListSearch.click();
        return this;
    }

    public TrainingListPage searchTrainingLike(String value){
        trainingListSearch.sendKeys(value);
        return this;
    }
    public TrainingListPage selectUkraine(){
        ukraine.click();
        return this;
    }

    public TrainingListPage selectLviv(){
        try {
            lviv.click();
        }catch (Exception e)
        {System.out.println(e.getMessage());}
        return this;
    }
    public TrainingListPage closeSearch(){
        try {
            arrow.click();
        }catch (Exception e)
        {System.out.println(e.getMessage());}
        return this;
    }
    public List<String> getListOfTrainingLocations (){
        List<String> tabs= new ArrayList<>();
        for(int i=0; i<trainingsLocations.size(); i++) {
            tabs.add( trainingsLocations.get(i).getText());
        }
        return tabs;
    }
    public TrainingListPage searchBySkills(){
        bySkillsButton.click();
        return this;
    }
    public TrainingListPage chooseJavaCheckBox(){
        javaCheckbox.click();
        return this;
    }

    public List<WebElement> getListOfTrainings (){
        List<WebElement> tabs= new ArrayList<>();
        for(int i=0; i<skillsSearchResultsList.size(); i++) {
            tabs.add( skillsSearchResultsList.get(i));
        }
        return tabs;
    }

    public   TrainingListPage chooseDataCheckBox(){
        dataCheckbox.forEach(WebElement::click);
        return this;
    }


}
