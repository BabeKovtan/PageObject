package pages.pagesBO;

import org.testng.Assert;
import pages.NewsPage;

import java.util.ArrayList;
import java.util.List;

public class NewsBO extends NewsPage {
    public NewsBO getListOfTabs(){
        List<String> tabLinks =  new NewsPage()
                .chooseMaterials()
                .getListOfTabLinks();
        List<String> linksExpected = new ArrayList<String>();
        linksExpected.add("NEWS");
        linksExpected.add("SUCCESS STORIES");
        linksExpected.add("MATERIALS");
        linksExpected.add("VIDEOS");
        Assert.assertEquals(tabLinks, linksExpected);
        return this;
    }
    public NewsBO getListOfMaterials(){
        List<String> materialLinksActual = new NewsPage()
                .getMaterialLinks();
        Assert.assertTrue(materialLinksActual.toString().contains("materials"));
        return this;
    }
}
