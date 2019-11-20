package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


import java.util.List;


public class FAQPage extends AbstractPage {
    @FindBy(css="div.accordion-item__opener")
    List<WebElement> openerList;
    @FindBy(css="label.accordion-item__question.ng-binding")
    List<WebElement> detailInformation;
//    public FAQPage getDetails() {
//        try {
//            openerList.forEach(WebElement::click);
//        }catch (Exception e){
//            System.out.println(e.getStackTrace());
//        }
//        return this;
//    }
    public List<WebElement> verifyInfo() {
        setWait(driver);
        Actions actions = new Actions(driver);
        //actions.sendKeys(Keys.ARROW_DOWN).perform();

        actions.moveToElement(openerList.get(0)).perform();
        setWait(driver);


            return detailInformation;




    }

}
