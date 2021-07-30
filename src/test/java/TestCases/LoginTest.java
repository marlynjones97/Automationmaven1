package TestCases;

import Base.BasePage;
import Pages.Home;
import Pages.Login;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BasePage {
    //create parent class BasePage class constructor inside the current class constructor using the word super because before intialisation
    //method we have the parent class cosntructor.why because before intialisation we created the constructor
    //for reading properties.

    Login loginobj;
    Home homepage;

    public LoginTest() {
        super();
    }

    //2.We will create the test annotation and under that we will create the a method and we will call the base page
    //initialisation method.

    @BeforeMethod
    public void setup() {
        super.initialisation();
    }

    //here under @Test u will call all the methods u defined in the Loginpage.
    @Test(priority=1)
    public void validateloginbuttontest(){
      homepage=  loginobj.validateLoginButton(prop.getProperty("username"), "password");
    }

    @Test(priority=2)
    public void verifyCRMlogotest(){
    boolean b1 = loginobj.verifyCRMlogo();
    Assert.assertTrue(b1);
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }








}
