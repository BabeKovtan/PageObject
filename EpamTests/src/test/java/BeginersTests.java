import org.testng.annotations.Test;
import pages.HomePage;
import pages.pagesBO.*;

public class BeginersTests extends BaseTest {

    @Test
    public void successLogInning() {
        new HomeBO()
                .changeLanguageToEnglish()
                .signIntoSystem();
        new AutorizationBO()
                .successfulLogIn()
                .getAutorizedUser();
        new HomePage()
                .getOut();
    }

    @Test
    public void unsuccessLogInning() {
         new HomeBO()
                .changeLanguageToEnglish()
                .signIntoSystem();
         new AutorizationBO()
                .unsuccessfulLogIn();

    }

    @Test
    public void testNewsPage() {
         new HomeBO()
                .changeLanguageToEnglish()
                 .signIntoSystem();
         new AutorizationBO()
                 .successfulLogIn()
                 .selectNews();
         new NewsBO()
                 .getListOfTabs()
                 .getListOfMaterials();
         new HomePage().getOut();
    }

    @Test
    public void trainingsSearchField() {

       new HomeBO()
               .changeLanguageToEnglish()
                .signIntoSystem();
       new AutorizationBO()
               .successfulLogIn()
               .selectTrainingsTab();
       new TrainingsBO()
               .getJavaTrainings()
               .getDataTrainings()
               .getPascalTrainings();
       new HomeBO().getOut();
   }


   @Test
    public void trainingsLocation () {
            new HomeBO()
                    .changeLanguageToEnglish()
                    .signIntoSystem();
            new AutorizationBO()
                    .successfulLogIn()
                    .selectTrainingsTab();
            new TrainingsBO()
                    .getTrainingsInLvivUkraine();
            new HomeBO().getOut();

    }


    @Test
    public void verifyFAQContent () {
        new HomeBO()
                .changeLanguageToEnglish()
                .signIntoSystem();
        new AutorizationBO()
                .successfulLogIn()
                .selectFAQ();
        new FAQBO().getAnswersOnMostCommonQuestions();
        new HomeBO().getOut();
    }


    @Test
    public void verifyAmountOfTheCities () {
        new HomeBO()
                .changeLanguageToEnglish()
                .signIntoSystem();
        new AutorizationBO()
                .successfulLogIn()
                .selectAbout();
        new AboutBO()
                .getCountOfCitiesWithEpamOffices();
        new HomeBO().getOut();
    }

}
