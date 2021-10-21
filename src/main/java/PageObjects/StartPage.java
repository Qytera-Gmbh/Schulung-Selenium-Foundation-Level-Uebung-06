package PageObjects;


import core.GeneralHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartPage extends GeneralHelper {
    public static final StartPage startPage = new StartPage();
    public static StartPage getInstance(){
        return startPage;
    }

    public static final By newEntries = By.xpath("//h2[contains(text(),'Neue Beiträge')]");

    public void checkHeaderContributionsIsShown(){
        Assertions.assertTrue(driver.findElement(newEntries).isDisplayed());
    }
}