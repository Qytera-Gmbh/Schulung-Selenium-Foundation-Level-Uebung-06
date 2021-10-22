package core;

import PageObjects.ContactPage;
import PageObjects.GeneralPage;
import PageObjects.StartPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GeneralHelper {
    public static WebDriver driver;
    public GeneralHelper(){
        driver = getDriver();
    }

    public ContactPage contactPage = ContactPage.getInstance();
    public StartPage startPage = StartPage.getInstance();
    public GeneralPage generalPage = GeneralPage.getInstance();

    public static WebDriver getDriver(){
        if(driver==null) {
            if(System.getenv("SELENIUM_BROWSER_CONFIG")!= null){
                if(System.getenv("SELENIUM_BROWSER_CONFIG").equalsIgnoreCase("chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                    return new ChromeDriver();
                }
                if(System.getenv("SELENIUM_BROWSER_CONFIG").equalsIgnoreCase("firefox")) {
                    System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\geckodriver.exe");
                    return new FirefoxDriver();
                }
                else{
                    //Default
                    System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                    return new ChromeDriver();
                }
            }
            else {
                //Default
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
                return new ChromeDriver();
            }
        }
        else{
            return driver;
        }
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
        driver.quit();
        driver=null;
    }
}
