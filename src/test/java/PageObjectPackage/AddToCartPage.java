package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

    WebDriver driver;

    public AddToCartPage(WebDriver driver){
        this.driver = driver ;
        PageFactory.initElements(driver,this);
        }

        @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    WebElement addToCartButton;

    @FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a")
    WebElement addedToCartIcon;

    public void addToCart(){
        addToCartButton.click();

    }
    public void addedToCart(){
        addedToCartIcon.click();
    }


    }

