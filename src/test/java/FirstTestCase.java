import core.SingletonBrowserClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static PageObjects.GeneralPage.generalPage;
import static PageObjects.StartPage.startPage;
import static PageObjects.ContactPage.contactPage;

public class FirstTestCase {

    SingletonBrowserClass singletonBrowserClass = SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
    WebDriver driver = singletonBrowserClass.getDriver();

    @Test
    @Tag("MyFirstTest")
    public void firstTestCase(){
        System.out.println("FirstTest");
        generalPage.doOpenBrowserWithLink("http://selenium.webtesting.eu/");
        startPage.checkHeaderContributionsIsShown();
        generalPage.clickOnElementWithId("menu-item-134");
        Assertions.assertEquals( "TESTSEITE-KONTAKTFORMULAR", driver.findElement(By.xpath("//h1[contains(text(),'Testseite-Kontaktformular')]")).getText());
        contactPage.checkBusinessIsChecked();
        contactPage.checkPrivateIsNotChecked();
    }

    @Test
    @Tag("MySecondTestcase")
    public void secondTestCase(){
        System.out.println("SecondTest");
    }


}
