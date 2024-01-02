package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObjects {

    @FindBy(xpath = "//div[@id='keyword-search']/input") public WebElement i_Home_Page_Search_Textbox;
    @FindBy(xpath = "//button[@class='btn btn-default btn-search']") public WebElement i_Home_Page_Search_Button;
    @FindBy(xpath = "//a[@class='navbar-brand']/img") public WebElement i_Home_Page_My_Bid_Food_Image;
    @FindBy(xpath = "//div[@id='branch-load']") public WebElement i_Home_Page_Loading_Spinner;
    @FindBy(xpath = "//span[text()='Product Details']") public WebElement i_Home_Page_Product_Details;
    @FindBy(xpath = "//h5[text()='No results found']") public WebElement i_Home_Page_No_Results_Found;
    @FindBy(xpath = "//a[contains(text(),'Home')]") public WebElement i_Home_Page_Home_Tab;
    @FindBy(xpath = "//button[contains(text(),'Browse by')]") public WebElement i_Home_Page_BrowseBy_Tab;
    @FindBy(xpath = "//button[contains(text(),'Orders')]") public WebElement i_Home_Page_Orders_Tab;
    @FindBy(xpath = "//button[contains(text(),'Reports')]") public WebElement i_Home_Page_Reports_Tab;
    @FindBy(xpath = "//button[contains(text(),'Accounts')]") public WebElement i_Home_Page_Accounts_Tab;
    @FindBy(xpath = "//button[contains(text(),'Promotions')]") public WebElement i_Home_Page_Promotions_Tab;
    @FindBy(xpath = "//div[text()='Welcome!']") public WebElement i_Home_Page_Welcome_Tab;
    @FindBy(xpath = "//div[text()='Fresh is best!']") public WebElement i_Home_Page_FreshIsBest_Tab;
    @FindBy(xpath = "//div[text()='Weet-bix for breakfast']") public WebElement i_Home_Page_WeetBix_Tab;
    @FindBy(xpath = "//span[text()='Quick Order']") public WebElement i_Home_Page_Quick_Order_Tab;
    @FindBy(xpath = "//button[@class='trolley-tab']") public WebElement i_Home_Page_Basket_Side_Tab;
    @FindBy(xpath = "//div[@class='warehouse ng-scope']/div/div/button") public WebElement i_Home_Page_Warehouse_Dropdown_Button;
    @FindBy(xpath = "//span[@class='preferred-checkbox']") public WebElement i_Home_Page_Preferred_Products_Checkbox;
    @FindBy(xpath = "//div[@class='home-panel hidden-sm hidden-xs ']") public WebElement i_Home_Page_My_Shortcuts_Panel;
    @FindBy(xpath = "//div[@class='delivery-widget-panel hidden-sm hidden-xs ng-scope']") public WebElement i_Home_Page_Deliveries_Panel;
    @FindBy(xpath = "//label[contains(text(),'Show:')]") public WebElement i_Home_Page_Show_Label;
    @FindBy(xpath = "//label[text()='Sort by:']") public WebElement i_Home_Page_Sort_By_Label;

}
