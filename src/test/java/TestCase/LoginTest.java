package TestCase;

import PageObjectPackage.LoginPage;
import PageObjectPackage.SearchResultPage;
import Utils.ExtentListenerClass;
import Utils.ReadExcelFile;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


@Listeners(ExtentListenerClass.class)


public class LoginTest extends BaseClass {
    LoginPage page;
    SearchResultPage page2;

    @Test(dataProvider = "I am data provider")
    public void verifyLogin(String username, String password, String expectedText)throws Exception

    {
        page = new LoginPage(driver);
        page2 = new SearchResultPage(driver);
        driver.get(url);
        page.enterUserName(username);
        log.info("Entered Username");
        System.out.println("Username is "+username);
        page.enterPassword(password);
        log.info("Entered password");
        System.out.println("Password is "+password);
        String text = page.verifyLogo();
            if(text.equalsIgnoreCase(expectedText)){
                Assert.assertTrue(true);
                System.out.println("expected text : "+expectedText);
                log.info("logo verified");
            }
            else{
                captureScreenshot("verifyLogin");
                Assert.assertTrue(false);
                log.info("logo verification is failed");
            }
            page.clickOnLoginBtn();
            log.info("clicked on login button");
        System.out.println("clicked on login button");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.info("Waited for 20 secs");
        System.out.println("Waited for 20 secs");
       String text2 =  page2.verifyText();
        System.out.println("text2 is "+text2);

       if(text2.contains("T-Shirt")){
           log.info("text verified");
           System.out.println("text verified");
       }
       else{
           log.info("Text is not present");
           System.out.println("Text is not present");
           captureScreenshot("verifyLogin");
           Assert.assertTrue(false);
       }

    }


    @AfterMethod
    public void Logout(){
        page2.logout();
        log.info("logged-Out");
        System.out.println("Logged-Out");
    }



    @DataProvider(name = "I am data provider")
    public Object[][] dataDriven()throws Exception{
        String filePath = System.getProperty("user.dir")+"//ExcelFile//Book3.xlsx";

        Object[][] dataArray = ReadExcelFile.getExcelData(filePath,"Sheet1");

        return dataArray ;
    }
}



