package alltestngcodepackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pompackage.SignUp_LogInPagePOM;

import java.time.Duration;

public class ExecutingWrongLogInMultipleTime
{
    WebDriver driver ;
    SignUp_LogInPagePOM logIn;

    @Test
    public void writeLogInInfo()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationexercise.com/login");
        logIn = new SignUp_LogInPagePOM(driver);

        logIn.getLogInEmailField().sendKeys("demoMail@mail.com");
        logIn.getLogInPasswordField().sendKeys("Password@1234567");

    }



    @Test(dependsOnMethods = "writeLogInInfo",invocationCount = 5)
    public void clickOnLogInButton()
    {

            logIn.getLogInButton().click();

    }
}
