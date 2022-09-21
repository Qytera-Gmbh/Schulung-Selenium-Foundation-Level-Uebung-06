package core;

import PageObjects.ContactPage;
import PageObjects.GeneralPage;
import PageObjects.StartPage;
import com.google.common.base.Strings;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class GeneralHelper {
    public static WebDriver driver;
    public GeneralHelper(){
        driver = getDriver();
    }

    public ContactPage contactPage = ContactPage.getInstance();
    public StartPage startPage = StartPage.getInstance();
    public GeneralPage generalPage = GeneralPage.getInstance();

    public static WebDriver getDriver(){
        List<String> lxResourcePath = new ArrayList<>();
        lxResourcePath.add("src/test/resources/");
        var operatingSystem = System.getProperty("os.name").toLowerCase();
        var browserConfig = System.getProperty("SELENIUM_BROWSER_CONFIG");

        if (driver != null) {
            return driver;
        }

        if (operatingSystem.contains("windows")) {
            lxResourcePath.add(".exe");
        }

        if (Strings.isNullOrEmpty(browserConfig) || browserConfig.equalsIgnoreCase("chrome")) {
            lxResourcePath.add(1,"chromedriver");
            System.setProperty("webdriver.chrome.driver", String.join("", lxResourcePath));
            return new ChromeDriver();
        }

        if (browserConfig.equalsIgnoreCase("firefox")) {
            lxResourcePath.add(1, "geckodriver");
            System.setProperty("webdriver.gecko.driver", String.join("", lxResourcePath));
            return new FirefoxDriver();
        }
        //Default
        throw new RuntimeException("Program cannot execute on this system and browser configuration.");
    }

    @BeforeEach
    public void browserOptions(){
        if(driver==null){
            getDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
}
