package alltestngcodepackage;

import baseclassPacckage.ParallelMethodBaseClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ParallelLogInUsingMethods extends ParallelMethodBaseClass
{
    @Test
    public void validLogIn()
    {
        au.clickOnElement(nav.getLogInSignUpLink());
        Assert.assertEquals(wbu.getDriver().getCurrentUrl(),"https://automationexercise.com/login","The SignUp Page is not loaded");
        Reporter.log("The SIgnUp Page is Loaded",true);
        au.writeInElement(signUp.getLogInEmailField(),user);
        au.writeInElement(signUp.getLogInPasswordField(),password);
        au.clickOnElement(signUp.getLogInButton());


    }

    @Test
    public void inValidLogIn()
    {
        au.clickOnElement(nav.getLogInSignUpLink());
        Assert.assertEquals(wbu.getDriver().getCurrentUrl(),"https://automationexercise.com/login","The SignUp Page is not loaded");
        Reporter.log("The SIgnUp Page is Loaded",true);
        au.writeInElement(signUp.getLogInEmailField(),"dummyMail@gmail.com");
        au.writeInElement(signUp.getLogInPasswordField(),"Password@12345");
        au.clickOnElement(signUp.getLogInButton());


    }


}
