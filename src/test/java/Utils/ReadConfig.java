package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    FileInputStream file;

    public ReadConfig(){
        try{
            properties = new Properties();
            file = new FileInputStream("C:\\Users\\rajat\\IdeaProjects\\WebAutomationTestingProject\\src\\main\\resources\\Config.properties");
            properties.load(file);
        }
        catch(Exception exception){
            System.out.println("Exception Handled "+exception.getMessage());
        }
    }

    public String getUrl(){
        String url = properties.getProperty("url");
        if(url != null){
            return url;
        }
        else{
            throw new  RuntimeException("url is not specified in configuration file");
        }

    }

    public String getBrowser(){
        String browser = properties.getProperty("browser");
        if (browser != null){
        return browser;
    }
        else{
            throw new RuntimeException("browser is  not specified in configuration file ");
        }
    }

    public String getConfirmationText(){
        return properties.getProperty("confirmationText");
    }

    public String getUsername(){
        return properties.getProperty("userName");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }



}
