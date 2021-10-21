package PageObjects;

import core.GeneralHelper;
import org.openqa.selenium.By;

public class GeneralPage extends GeneralHelper {
    public static final GeneralPage generalPage = new GeneralPage();
    public static GeneralPage getInstance(){
        return generalPage;
    }

    public void doOpenBrowserWithLink(String url){
        driver.get(url);
    }

    public void clickOnElementWithId(String id){
        driver.findElement(By.id(id)).click();
    }

}
