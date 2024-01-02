package Utilities;

import PageObjects.LoginPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.HashMap;


public class GeneralFunctions {
    public static WebDriver driver;

    public static synchronized WebDriver initialiseDriver(String browser) throws Exception{
        try {
            HashMap<String, Object> chromePrefs = null; //new HashMap<String, Object>();
            ChromeOptions chromeOptions = null; //new ChromeOptions();

            if ("phantomjs".equals(browser)) {
                WebDriverManager.phantomjs().setup();
                driver = new PhantomJSDriver();
            } else if ("firefox".equals(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else if ("internetExplorer".equals(browser)) {
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            } else if ("chrome_headless".equals(browser)) {
                WebDriverManager.chromedriver().setup();
                chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "Downloads");
                chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("disable-gpu");
                chromeOptions.addArguments("--window-size=1920,1080");
                chromeOptions.addArguments("--start-maximized");
                driver = new ChromeDriver(chromeOptions);
            } else {
                WebDriverManager.chromedriver().setup();
                chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "Downloads");
                chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
                driver = new ChromeDriver(chromeOptions);
            }
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return driver;
    }

    public static void enterLoginCredential(WebDriver driver, String url, String username, String password) throws Exception {
        try {
            LoginPageObjects loginPageObjects = new LoginPageObjects();
            PageFactory.initElements(driver, loginPageObjects);
            driver.manage().window().maximize();
            driver.navigate().to(url);
            loginPageObjects.i_Login_Username.sendKeys(username);
            loginPageObjects.i_Login_Password.sendKeys(password);
            loginPageObjects.i_Login_Button.click();
        } catch (Exception e) {
            throw new Exception("Unable to enter login credentials due to reason - " + e.getMessage());
        }
    }

}





