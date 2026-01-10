package listenerspackage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.*;

import java.io.File;
import java.lang.reflect.Field;


public class CustomListener implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result)
    {
        Reporter.log("The method is Starting ~~ "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("This method is passed ~~ "+result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("This method is failed ~~ "+result.getMethod().getMethodName());


        try
        {
            Object obj= result.getInstance();

            Field desiredField = null;
            desiredField = obj.getClass().getDeclaredField("driver");
            desiredField.setAccessible(true);
            WebDriver driver = (WebDriver) desiredField.get(obj);

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File tempFile = screenshot.getScreenshotAs(OutputType.FILE);
            File srcFile = new File("./Screenshots/"+result.getMethod().getMethodName()+".png");
            FileUtils.copyFile(tempFile,srcFile);

        }
        catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("This method is Skipped ~~ "+result.getMethod().getMethodName());
    }

    @Override
    public void onStart(ITestContext context) {
        Reporter.log("This suite is starting "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
       Reporter.log("This suite is finished"+context.getName());
    }
}
