package pages.pagesBO;

import org.testng.Assert;
import pages.AboutPage;
import pages.HomePage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AboutBO extends AboutPage {
    public AboutBO getCountOfCitiesWithEpamOffices(){
        List<Integer> citiesAmount = new AboutPage()
                .getCitiesCount();
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(6);
        expected.add(2);
        expected.add(10);
        expected.add(5);
        System.out.println(citiesAmount);
//        for(int i=0;i<expected.size();i++){
//            Assert.assertEquals(citiesAmount.get(i),expected.get(i),String.format("Some Country has not correct amount of cities with Epam offices"));
//
//        }
      citiesAmount.forEach(element->Assert.assertEquals(citiesAmount.get(element),expected.get(element),String.format("Some Country has not correct amount of cities with Epam offices")));
       //Assert.assertEquals(citiesAmount.size(),expected.size(),String.format("Some Country has not correct amount of cities with Epam offices"));


        return this;
    }
}
