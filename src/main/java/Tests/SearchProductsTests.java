package Tests;

import PageObjects.HomePageObjects;
import PageObjects.LoginPageObjects;
import Utilities.Constants;
import Utilities.GeneralFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.logging.Logger;


public class SearchProductsTests extends GeneralFunctions {
    LoginPageObjects loginPageObjects;
    HomePageObjects homePageObjects;
    Logger logger;

    @Test(priority = 1)
    public void Login() throws Exception {
        try {
            WebDriver driver = GeneralFunctions.initialiseDriver("chrome");
            loginPageObjects = new LoginPageObjects();
            PageFactory.initElements(driver, loginPageObjects);
            logger = Logger.getLogger("My Logs");
            logger.info("Launching browser and performing user login");
            GeneralFunctions.enterLoginCredential(driver, Constants.homePageURL,Constants.username,Constants.password);

            homePageObjects = new HomePageObjects();
            PageFactory.initElements(driver,homePageObjects);
            new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(homePageObjects.i_Home_Page_My_Bid_Food_Image));

            Assert.assertTrue(homePageObjects.i_Home_Page_My_Bid_Food_Image.isDisplayed(),"My Bid Food logo not found on Home Page");
            logger.info("Logging to Bid Food Home Page successfully");

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Test(priority = 2)
    public void HomePageAvailabilityTest() throws Exception{
        try{
            logger.info("Checking the availability on Bidfood Home Page ");
            Assert.assertTrue(homePageObjects.i_Home_Page_Home_Tab.isDisplayed(),"Home tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_BrowseBy_Tab.isDisplayed(), "Browser By tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Orders_Tab.isDisplayed(), "Orders tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Reports_Tab.isDisplayed(), "Reports tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Accounts_Tab.isDisplayed(), "Accounts tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Promotions_Tab.isDisplayed(), "Promotions tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Search_Textbox.isDisplayed(), "Search text box not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_FreshIsBest_Tab.isDisplayed(), "Fresh Is Best tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_WeetBix_Tab.isDisplayed(), "Weet Bix tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Quick_Order_Tab.isDisplayed(), "Quick Order tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Basket_Side_Tab.isDisplayed(), "Basket side tab not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Warehouse_Dropdown_Button.isDisplayed(), "Warehouse dropdown not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Preferred_Products_Checkbox.isDisplayed(), "Preferred Products checkbox not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_My_Shortcuts_Panel.isDisplayed(), "My Shortcuts panel not found on Home Page");
            Assert.assertTrue(homePageObjects.i_Home_Page_Deliveries_Panel.isDisplayed(), "Deliveries panel not found on Home Page");
        } catch(AssertionError a) {
            throw new Exception("Home Page Availability Test failed due to reason : - " + a.getMessage());
        } catch (Exception e){
            throw new Exception("Home Page Availability Test failed due to reason : - " + e.getMessage());
       }
    }

    @Test(priority = 3)
    public void SearchProductsTest() throws Exception{
        try {
            logger.info("Starting to test searching for products");
            homePageObjects.i_Home_Page_Search_Textbox.sendKeys(Constants.productName);
            homePageObjects.i_Home_Page_Search_Button.click();
            new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(homePageObjects.i_Home_Page_Show_Label));
            new WebDriverWait(driver,30).until(ExpectedConditions.visibilityOf(homePageObjects.i_Home_Page_Sort_By_Label));
            new WebDriverWait(driver,30).until(ExpectedConditions.invisibilityOf(homePageObjects.i_Home_Page_Loading_Spinner));
            Thread.sleep(2000);
            if(homePageObjects.i_Home_Page_Product_Details.isDisplayed()){
                logger.info("Products name containing " + Constants.productName + " are found");
            }else if(homePageObjects.i_Home_Page_No_Results_Found.isDisplayed()){
                logger.info("Products are not found");
            }
        } catch(AssertionError a) {
            throw new Exception("Search Products Test failed due to reason : - " + a.getMessage());
        } catch (Exception e){
            throw new Exception("Search Products Test failed due to reason : - " + e.getMessage());
        }
    }
}
