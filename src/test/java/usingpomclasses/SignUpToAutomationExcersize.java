package usingpomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pompackage.SignUpPagePOM;
import pompackage.SignUp_LogInPagePOM;

import java.time.Duration;

public class SignUpToAutomationExcersize
{
    public static void main(String[] args) {

        try
        {
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://automationexercise.com/login");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            SignUp_LogInPagePOM signUpAndLogIn = new SignUp_LogInPagePOM(driver);
            SignUpPagePOM signUp = new SignUpPagePOM(driver);

            signUpAndLogIn.enterSignUpPage("demo","demoMail@mail.com");

            signUp.getMaleRadioButton().click();
            signUp.getSignUpPasswordField().sendKeys("Password@12345");
            signUp.getFirstNameField().sendKeys("FirstName");
            signUp.getLastNameField().sendKeys("LastName");
            signUp.getAddress1Field().sendKeys("Hyderabad");
            signUp.getStateField().sendKeys("telangana");
            signUp.getCityField().sendKeys("Hyderabad");
            signUp.getZipCodeField().sendKeys("500060");
            signUp.getMobileNumberField().sendKeys("9988776655");
            signUp.getCreateAccountButton().click();






        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
