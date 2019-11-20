package pages;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AutorizationPage extends AbstractPage{
    @FindBy(id="signInEmail")
    WebElement mailInput;
    @FindBy(id="signInPassword")
    WebElement passwordInput ;
    @FindBy(css="input.popup-reg-sign-in-form__sign-in[value=\"Sign in\"]")
    WebElement signInButton;
    @FindBy(css="div.popup__error-message.ng-binding")
    WebElement alert;

    public AutorizationPage inputMail( String mail)
    {
        getFluentWait(mailInput).sendKeys(mail);
        return this;
    }
    public AutorizationPage inputPassword(String password){
        passwordInput.sendKeys(password);
        return this;
    }
    public HomePage submitLogIn(){
        try {
            getFluentWait(signInButton).click();
        }catch (TimeoutException e) {
            System.out.println("Timeout");
        }
        return new HomePage();
    }

    public AutorizationPage submitUnsuccessfulLogIn(){
        signInButton.click();
        return this;
    }

    public String getAlert(){
        try {
            return getFluentWait(alert).getText();
        }catch (TimeoutException e) {
            System.out.println("Timeout");
        }

        return getFluentWait(alert).getText();
    }

}
