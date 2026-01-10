package alltestngcodepackage;

import baseclassPacckage.Registration_ExistingMailId_BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterUserUsingExistingEmailHardAssertion extends Registration_ExistingMailId_BaseClass
{
    WebDriverWait wait;
    WebDriver driver ;



    @Test
    public void verifyHomePageVisibility()
    {
        driver = wbu.getDriver();

        String currentUrl  = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl,url,"The HomePage url is different");
        Reporter.log("The HomePage is displyed",true);
    }

    @Test(dependsOnMethods ="verifyHomePageVisibility" )
    public void clickOnSignUpLogInLink()
    {
        au.clickOnElement(nav.getLogInSignUpLink());
        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login","The LogIn and SignUp Page is not displyed");
        Reporter.log("The LogIn and SignUp Page is displayed",true);
    }

    @Test(dependsOnMethods = "clickOnSignUpLogInLink")
    public void verifyNewSignUpHeading()
    {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        String actualHeading = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='signup-form']/child::h2")))).getText();

        Assert.assertEquals(actualHeading,"New User Signup!","The New User SignUp Heading is not visible");
        Reporter.log("The New User SignUp Heading is visible",true);
    }

    @Test(dependsOnMethods = "verifyNewSignUpHeading")
    public void enterNameAndExistingEmailAddress()
    {
        au.writeInElement(signUp.getSignUpUserNameField(),"John Doe");
        au.writeInElement(signUp.getSignUpEmailField(),user);
        au.clickOnElement(signUp.getSignUpButton());
    }

    @Test(dependsOnMethods = "enterNameAndExistingEmailAddress")
    public void verifyExistingMailIdWarning()
    {
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]")).isDisplayed(),"The Existing User Warning message is not displayed");
        Reporter.log("The Existing User Warning Message is displayed",true);
    }

}
