package PageObjects;


import core.GeneralHelper;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends GeneralHelper {
    public static final StartPage startPage = new StartPage();
    public static StartPage getInstance(){
        return startPage;
    }

    public static final By newEntries = By.xpath("//h2[contains(text(),'Neue Beiträge')]");

    public void checkHeaderContributionsIsShown(){
        WebDriverWait warten = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assertions.assertTrue(warten.until(ExpectedConditions.elementToBeClickable(driver.findElement(newEntries))).isDisplayed());
    }
}
