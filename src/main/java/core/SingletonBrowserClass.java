package core;

import com.google.common.base.Strings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

public class SingletonBrowserClass {
    //Instance of singleton class
    private static SingletonBrowserClass instanceOfSingletonBrowserClass=null;

    private WebDriver driver;

    //Constructor
    private SingletonBrowserClass(){
        List<String> lxResourcePath = new ArrayList<>();
        lxResourcePath.add("src/test/resources/");
        var operatingSystem = System.getProperty("os.name").toLowerCase();
        var browserConfig_alt = System.getProperty("SELENIUM_BROWSER_CONFIG");
        var browserConfig = System.getenv("SELENIUM_BROWSER_CONFIG");
        if (operatingSystem.contains("windows")) {
            lxResourcePath.add(".exe");
        }

        // Create chrome driver object
        if (Strings.isNullOrEmpty(browserConfig) || browserConfig.equalsIgnoreCase("chrome")) {
            lxResourcePath.add(1,"chromedriver");
            System.setProperty("webdriver.chrome.driver", String.join("", lxResourcePath));
            driver = new ChromeDriver();
        }

        // Create firefox driver object
        if (browserConfig.equalsIgnoreCase("firefox")) {
            lxResourcePath.add(1, "geckodriver");
            System.setProperty("webdriver.gecko.driver", String.join("", lxResourcePath));
            driver = new FirefoxDriver();
        }

        //Default
        throw new RuntimeException("Program cannot execute on this system and browser configuration.");
    }

    //To create instance of class
    public static SingletonBrowserClass getInstanceOfSingletonBrowserClass(){
        if(instanceOfSingletonBrowserClass==null){
            instanceOfSingletonBrowserClass = new SingletonBrowserClass();
        }
        return instanceOfSingletonBrowserClass;
    }

    //To get the driver
    public WebDriver getDriver()
    {
        return driver;
    }

}
