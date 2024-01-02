package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObjects {

    @FindBy(xpath = "//input[@id='UserName']")  public WebElement i_Login_Username;
    @FindBy(xpath = "//input[@id='Password']")  public WebElement i_Login_Password;
    @FindBy(xpath = "//input[@id='submitBtn']") public WebElement i_Login_Button;

}
