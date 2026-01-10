package alltestngcodepackage;

import baseclassPacckage.AddItemToCartBaseClass;
import baseclassPacckage.Registration_ExistingMailId_BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Validating_VisibilityOfElement_SoftAssertion extends Registration_ExistingMailId_BaseClass
{
WebDriver driver ;

    @Test
    public void vrifyHomePage()
    {
        driver = wbu.getDriver();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/","The HomePage is not displayed");
        Reporter.log("The Home Page is Displayed",true);

        softAssert.assertTrue(nav.getLogInSignUpLink().isDisplayed(),"The SignUp/LogIn Link is not displyed");
        Reporter.log("The SignUp/LogIn Page is Displayed",true);

        softAssert.assertTrue(nav.getHomePageLink().isDisplayed(),"The HomePage Link is not Displayed");
        Reporter.log("The HomePage Link is Displayed",true);

        softAssert.assertFalse(nav.getCartPageLink().isDisplayed(),"The CartPage Link is not Displayed");
        Reporter.log("The CartPage Link is Displayed",true);

        au.clickOnElement(nav.getLogInSignUpLink());

        softAssert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/login","The SignUp/LogInPage is not displayed");
        Reporter.log("The SignUp/LogInPage is displayed",true);

        softAssert.assertAll();
    }
}
