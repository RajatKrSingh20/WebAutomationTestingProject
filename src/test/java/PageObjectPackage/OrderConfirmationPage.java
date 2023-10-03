package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {

    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//h2[contains(text(),'Thank you for your order!')]")
    WebElement confirmationText;

    public String getConfirmationText(){

        return confirmationText.getText();

    }





}
