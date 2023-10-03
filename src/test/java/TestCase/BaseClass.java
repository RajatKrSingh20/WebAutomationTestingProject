package TestCase;

import Utils.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.io.File;

public class BaseClass {

    WebDriver driver ;

    ReadConfig readConfig = new ReadConfig();

    String browser = readConfig.getBrowser();
    String url = readConfig.getUrl();

    String confirmationText = readConfig.getConfirmationText();

    String userName = readConfig.getUsername();
    String password = readConfig.getPassword();

    Logger log;

    @BeforeClass
    public void setup(){
        switch (browser.toLowerCase()){
            case "chrome":

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":

                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            default:

                driver = null;
                System.out.println("driver is null");
        }
         log = LogManager.getLogger("WebAutomationTestingProject");
    }

    @AfterClass
    public void tearDown(){

        driver.close();
        driver.quit();
    }

    public void captureScreenshot( String testName){

        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        File dstFile = new File(System.getProperty("user.dir")+"//ScreenShots//"+testName+".png");
        try {
            FileHandler.copy(file, dstFile);
        }catch(Exception exception){
            System.out.println("exception handled"+exception.getMessage());
        }
    }

}
