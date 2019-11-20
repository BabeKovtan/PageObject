package pages.pagesBO;

import org.testng.Assert;
import pages.AutorizationPage;
import pages.ConstantVariable;
import pages.HomePage;

public class HomeBO extends HomePage {

    public HomeBO changeLanguageToEnglish(){
        new HomeBO()
                .selectEnglish();
        return new HomeBO();
    }


}
