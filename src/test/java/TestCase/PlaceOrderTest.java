package TestCase;

import PageObjectPackage.*;
import Utils.ExtentListenerClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

@Listeners(ExtentListenerClass.class)

public class PlaceOrderTest extends BaseClass {

    LoginPage page;
    AddToCartPage page1 ;
    OrderConfirmationPage page2;
    YourCartPage page3;

    YourInformationPage page4;
    FinishPage page5;
    SearchResultPage page6;


    @BeforeMethod
    public void lauchWebsite(){
        page = new LoginPage(driver);
        page1 = new AddToCartPage(driver);
        page2 = new OrderConfirmationPage(driver);
        page3 = new YourCartPage(driver);
        page4 = new YourInformationPage(driver);
        page5 = new FinishPage(driver);
        page6 = new SearchResultPage(driver);

        driver.get(url);
        page.enterUserName(userName);
        log.info("Entered Username");
        System.out.println("Username is "+userName);
        page.enterPassword(password);
        log.info("Entered password");
        System.out.println("Password is "+password);
        page.clickOnLoginBtn();
        log.info("clicked on login button");
        System.out.println("clicked on login button");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        log.info("Waited for 20 secs");
        System.out.println("Waited for 20 secs");

    }

    @Test
    public void placeOrder(){

        page1.addToCart();
        log.info("item added to cart");
        System.out.println("item added to cart");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        page1.addedToCart();
        log.info("Clicked on add to cart icon");
        System.out.println("Clicked on add to cart icon");
        page3.clickOnCheckout();
        System.out.println("clicked on checkout button");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        page4.enterInformation();
        System.out.println("Entered all the personal information");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        page5.clickOnFinish();
        System.out.println("clicked on finish button");
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        String text = page2.getConfirmationText();
        if(text.equalsIgnoreCase(confirmationText)){
            System.out.println("text matched "+text);
        }
        else{
            System.out.println("text doesn't matched");
            captureScreenshot("placeOrder");
            Assert.assertTrue(false);
        }

    }
    @AfterMethod
    public void Logout(){
        page6.logout();
        log.info("logged-Out");
        System.out.println("Logged-Out");
    }





}
