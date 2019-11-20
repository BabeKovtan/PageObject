package pages;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.pagesBO.FAQBO;


public class HomePage extends AbstractPage {
    @FindBy(css="div.location-selector__globe")
    WebElement localization;
    @FindBy(xpath="//p[@class=\"header-auth__signin\" and contains(.,\"Sign in\") ]//span")
    WebElement signIn;
    @FindBy(xpath="//a[contains(text(),\"English\")]")
    WebElement ukrainian;
    @FindBy(css="ul.main-nav__list a.topNavItem.training.click.hover")
    WebElement trainingList;
    @FindBy(xpath="//div[@class=\"user-info__name\"]//parent::a[@class=\"user-info dropdown-toggle\"]")
    WebElement logOutButton;
    @FindBy(xpath="//div[@class='dropdown-menu']//ancestor::div[contains(@class,'dropdown user-info-desktop open')]//a[contains(text(),\"Sign out\")]")
    WebElement logOut;
    @FindBy(css="nav.main-nav a.topNavItem.news.click.hover")
    WebElement news;
    @FindBy(css="div.user-info__name")
    WebElement userMail;
    @FindBy(css="ul.main-nav__list a.topNavItem.faq.click.hover")
    WebElement fAQ ;
    @FindBy(css="ul.main-nav__list a.topNavItem.about.click.hover")
    WebElement about ;

    public HomePage selectEnglish(){

        localization.click();
        ukrainian.click();
        return this;
    }

    public AutorizationPage signIntoSystem(){

        try {
            getFluentWait(signIn).click();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return new AutorizationPage();
    }

    public String getAutorizedUser()  {
        try{
            return getFluentWait(userMail).getText();
        } catch (Exception e){
            System.out.println(e.getStackTrace()); }
         return waitVisible(userMail).getText();
    }
    public AutorizationPage getOut(){
        try {
            getFluentWait(logOutButton).click();
            getFluentWait(logOut).click();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return new AutorizationPage();
    }

    public NewsPage selectNews(){
        news.click();
        return new NewsPage();
    }
    public TrainingListPage selectTrainingsTab(){
        trainingList.click();
        return new TrainingListPage();
    }
    public AboutPage selectAbout() {
        try{
        getFluentWait(about).click();
    }catch (Exception e){
        System.out.println(e.getStackTrace());
        }
        return new AboutPage();
    }
    public FAQBO selectFAQ(){
        try{
        getFluentWait(fAQ).click();
    }catch (Exception e){
        System.out.println(e.getStackTrace());
    }
        return new FAQBO();
    }
}
