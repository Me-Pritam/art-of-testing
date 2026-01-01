package alltestngcodepackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UingDependsOnMethods
{
    @Test
    public void logIn()
    {
        Reporter.log("LogIn is successful",true);
    }

    @Test(dependsOnMethods = "logIn")
    public void openHomePage()
    {
        Reporter.log("The HomePage is displayed",true);
    }

    @Test(dependsOnMethods = "logIn")
    public void addItemToCart()
    {
        Reporter.log("The Item is added to cart",true);
    }

    @Test(dependsOnMethods = "addItemToCart",priority = 2)
    public void goToCart()
    {
        Reporter.log("The Cart Page is displayed",true);
    }

    @Test(dependsOnMethods = "goToCart",priority = 3)
    public void buyItem()
    {
        Reporter.log("The Item is purchased",true);
    }
}
