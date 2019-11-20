package pages.pagesBO;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.FAQPage;


import java.util.List;

public class FAQBO extends FAQPage {
    public FAQBO getAnswersOnMostCommonQuestions(){
        List<WebElement> detailInformation = new FAQPage()
               // .getDetails()
                .verifyInfo();
        detailInformation.forEach(element -> Assert.assertTrue(element.getText().toUpperCase().contains("A"), String.format("Element %s does not contain 'Epam' word.", element)));
        return this;
    }
}
