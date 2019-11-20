package pages.pagesBO;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ConstantVariable;
import pages.HomePage;
import pages.TrainingListPage;

import java.util.List;

public class TrainingsBO {
    public TrainingsBO getJavaTrainings(){
        List<WebElement> javaTrainings=  new TrainingListPage()
                .searchTraining()
                .searchBySkills()
                .chooseJavaCheckBox()
                .closeSearch()
                .getListOfTrainings();
        javaTrainings.forEach(element-> Assert.assertTrue(element.getText().contains("JAVA"),String.format("Element %s does not contain 'Java' word.",element)));

        return this;
    }

    public TrainingsBO getDataTrainings(){
        List<WebElement> dataTrainings= new TrainingListPage()
                .searchTraining()
                .searchBySkills()
                .chooseDataCheckBox()
                .closeSearch()
                .getListOfTrainings();
        dataTrainings.forEach(element-> Assert.assertTrue(element.getText().contains("DATA"),String.format("Element %s does not contain 'Data' word.",element)));
        return  this;
    }

    public TrainingsBO getPascalTrainings(){
        int listSizeOfPascalTrainings= new TrainingListPage()
                .searchTraining()
                .searchBySkills()
                .searchTrainingLike(ConstantVariable.pascal)
                .getListOfTrainings().size();
        Assert.assertEquals(listSizeOfPascalTrainings,0,String.format("There are some pascal trainings."));
        return this;
    }

    public TrainingsBO getTrainingsInLvivUkraine(){
        List<WebElement> lvivTrainings= new TrainingListPage()
                .searchTraining()
                .selectUkraine()
                .selectLviv()
                .closeSearch()
                .getListOfTrainings();
        lvivTrainings.forEach(element -> Assert.assertTrue(element.getText().contains(ConstantVariable.location),
                String.format("Element %s does not contain 'Lviv, Ukraine' word.", element)));

        return this;
    }
}
