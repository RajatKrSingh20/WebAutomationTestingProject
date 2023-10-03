package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import java.io.File;

public class ExtentListenerClass implements ITestListener {

    ExtentSparkReporter reporter ;
    ExtentReports reports ;
    ExtentTest test ;

    public ExtentListenerClass(){
        reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//report.html");
        reports = new ExtentReports();
    }
    public void configureReport(){

        reports.attachReporter(reporter);
        reporter.config().setDocumentTitle("Extent Report");
        reporter.config().setReportName("my first report");


    }
    @Override
    public void onStart(ITestContext context){
        System.out.println("onStart method invoked "+context.getName());
        configureReport();
    }
    @Override
    public void onFinish(ITestContext context){
        System.out.println("onFinish method invoked "+context.getName());
        reports.flush();
    }
    @Override
    public void onTestStart(ITestResult result){

    }
    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Passed is "+result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.PASS,"Name of testCase passed is "+result.getName()+"hello");
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test failed is "+result.getName());
        test = reports.createTest(result.getName());
        test.log(Status.FAIL,"Test failed is "+result.getName());

        String path = System.getProperty("user.dir")+"//ScreenShots//"+result.getName()+".png";

        File file = new File(path);

        if(file.exists()){
          test.fail("captured is below"+test.addScreenCaptureFromPath(path) );
            System.out.println("captured");
        }
    }

    @Override
    public void onTestSkipped(ITestResult result){

    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){

    }









}
