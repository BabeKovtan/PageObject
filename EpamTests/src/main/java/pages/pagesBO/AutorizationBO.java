package pages.pagesBO;

import org.testng.Assert;
import pages.AbstractPage;
import pages.AutorizationPage;
import pages.ConstantVariable;
import pages.HomePage;

public class AutorizationBO  {


    public HomePage successfulLogIn(){

        String userName = new AutorizationPage()
                .inputMail(ConstantVariable.email)
                .inputPassword(ConstantVariable.password)
                .submitLogIn()
                .getAutorizedUser();
        Assert.assertEquals(userName, ConstantVariable.user, String.format("User mail is at top-right corner."));
        return new HomePage();
    }
    public AutorizationBO unsuccessfulLogIn(){
        String alert = new AutorizationPage()
                .inputMail(ConstantVariable.wrongEmail)
                .inputPassword(ConstantVariable.password)
                .submitUnsuccessfulLogIn()
                .getAlert();

        Assert.assertEquals(alert, ConstantVariable.alert, String.format("Alert is shown, user don't logined"));
        return this;
    }
}
