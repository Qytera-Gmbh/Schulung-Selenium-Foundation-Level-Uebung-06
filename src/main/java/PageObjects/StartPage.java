package PageObjects;

import core.SingletonBrowserClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static PageObjects.GeneralPage.generalPage;

public class StartPage  {
    public static final StartPage startPage = new StartPage();

    SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = singletonBrowserClass.getDriver();

    public static final By newEntries = By.xpath("//h2[contains(text(),'Neue Beiträge')]");

    public void checkHeaderContributionsIsShown(){
        generalPage.waitUntilElementClickable(driver.findElement(newEntries),10).isDisplayed();
    }
}
