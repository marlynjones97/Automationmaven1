package Base;

import Utiltiies.Util;
import com.sun.webkit.dom.DOMWindowImpl;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.swing.text.Utilities;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public static Properties prop;
    public static WebDriver driver;

    //1.intialise the prop varable inside the constructor.
    public void BasePage() {
        try {
           Properties prop;
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/main/java/Config/config.properties");
            System.out.println("This is fileinput"+ip.toString());
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //2. Create an intialisaiton method.
    public void initialisation() {
        //read the properties file.
        String browsername = prop.getProperty("browser");
        if (browsername.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:/Selenium/Chrome/chromedriver.exe");
            driver = new ChromeDriver();
            System.out.println("Hello1");
        } else if (browsername.equals("FF")) {
            System.setProperty("webdriver.chrome.driver", "C:/Selenium/Chrome/chromedriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Util.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }


        public void navigateback(){
            driver.navigate().back();
        }

        public void scrollup(){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,650)");

        }

    }


