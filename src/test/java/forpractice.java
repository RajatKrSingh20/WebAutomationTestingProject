import Utils.ReadExcelFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class forpractice {

    WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        System.out.println("Browser launched and waited for 20 secs");

    }

    @Test(dataProvider = "dataProviding")
    public void launchSite(String keyword1, String keyword2){

        WebElement element = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        element.sendKeys(keyword1+" "+ keyword2);
        element.sendKeys(Keys.ENTER);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();

    }

    @DataProvider(name = "dataProviding")
    public Object[][] datas()throws Exception{
        String path = "C:\\Users\\rajat\\Desktop\\honeysingh\\data\\Book2.xlsx";
        Object[][] data = ReadExcelFile.getExcelData(path,"honeysingh");


        return data;
    }
    @AfterClass
    public void finalTearDown(){
        driver.quit();

    }



}
