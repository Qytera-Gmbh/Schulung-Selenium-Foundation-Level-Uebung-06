package PageObjects;

import core.SingletonBrowserClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralPage    {

    public static final GeneralPage generalPage = new GeneralPage();

    SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = singletonBrowserClass.getDriver();
    public void doOpenBrowserWithLink(String url){
        driver.get(url);
    }

    public void clickOnElementWithId(String id){
        driver.findElement(By.id(id)).click();
    }

    public WebElement waitUntilElementClickable(WebElement e, int duration){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.elementToBeClickable(e));
        return e;
    }


}
