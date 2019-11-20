package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.xpath;


public class NewsPage extends AbstractPage {


    @FindBy(xpath="//span[contains(text(),\"Materials\")]")
    WebElement materials ;
    @FindBy(css="div.tab-nav__item.ng-scope>span.ng-binding")
    List<WebElement> tabsLinksActual;
    @FindBy(css="div.news-page-item__title>a.ng-binding")
    List<WebElement> materialLinksActual;
    public NewsPage chooseMaterials(){
        try {
           getFluentWait( materials).click();
        }catch (Exception e){
            System.out.println(e.getStackTrace()); }
        return this;
    }
    public List<String> getListOfTabLinks (){
        List<String> tabs= new ArrayList<>();
        for(int i=0; i<tabsLinksActual.size(); i++) {
            tabs.add( tabsLinksActual.get(i).getText());
        }
       return tabs;
    }

    public List<String> getMaterialLinks (){
        List<String> mater= new ArrayList<>();
        for(int i=0; i<materialLinksActual.size(); i++) {
            mater.add( materialLinksActual.get(i).getText());
        }
        return mater;
    }


}
