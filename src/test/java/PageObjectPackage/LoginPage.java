package PageObjectPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

WebDriver driver ;

public LoginPage(WebDriver briver){
    driver = briver;
    PageFactory.initElements(briver,this);
}

@FindBy(xpath="//div[contains(text(),'Swag Labs')]")
 WebElement logo ;


@FindBy(xpath = "//input[@id='user-name']")
 WebElement userId;

@FindBy(xpath="//input[@id='password']")
 WebElement password;

@FindBy(xpath="//input[@id='login-button']")
 WebElement loginBtn;

public String verifyLogo(){
    String logoOnLoginPage = logo.getText();
    return logoOnLoginPage ;
}
public void enterUserName(String username){

    userId.sendKeys(username);

}
public void enterPassword(String password){
   this.password.sendKeys(password);
}
public void clickOnLoginBtn(){
    loginBtn.click();
}



}
