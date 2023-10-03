package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {

    WebDriver driver;
    Actions action;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   @FindBy(xpath = "//*[@id=\"item_1_title_link\"]/div")
   public WebElement product;

    @FindBy(xpath="//button[@id='react-burger-menu-btn']")
    public WebElement optionButton;

    @FindBy(xpath="//a[@id='logout_sidebar_link']")
    WebElement logoutButton;


    public String verifyText(){

        action = new Actions(driver);
        action.moveToElement(product).build().perform();

        String text = product.getText();

        return text;
    }

    public void logout(){
        action = new Actions(driver);
        action.moveToElement(optionButton).click().build().perform();
        logoutButton.click();


    }

}
