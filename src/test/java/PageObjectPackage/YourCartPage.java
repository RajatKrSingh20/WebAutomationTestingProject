package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class YourCartPage {

    WebDriver driver;

    public YourCartPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement checkOutButton;

    public void clickOnCheckout(){
        checkOutButton.click();
    }





}
