package Pages;
import Base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login  extends BasePage {

    //1.Create PageFactory or By locators. for the Login Page elements.
    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement LoginButton;

    //CRMLogo
    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement CRMLogo;

    //SignUp button
    @FindBy(xpath = "//a[contains(text(),'Sign Up')]")
    WebElement SignUp;

    //2.Create constructor of this page class to initialise the above webelements.
    public Login() {
        PageFactory.initElements(driver, this);//this driver is coming from base page,this means current class objects..
    }

    //3.Actions/Methods for the above webelements.
    public Home validateLoginButton(String un, String pwd) {
        username.sendKeys(un);
        password.sendKeys(pwd);
        LoginButton.click();
        return new Home();
    }

    public boolean verifyCRMlogo() {
        return CRMLogo.isDisplayed();
    }

    public String verifyHomepagetitle() {
        return driver.getTitle();
    }

    public Home clickonSignuplink() {
        return new Home();
    }

    public Home clickonPricinglink() {
        return new Home();

    }

    public Home clickonFeatureslink() {
        return new Home();
    }

    public Home clickonCustomerlink() {
        return new Home();
    }

    public Home clickonContactlink() {
        return new Home();

    }
}
