package alltestngcodepackage;

import baseclassPacckage.CrossBrowserBaseClass;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CrossBrowserExecution extends CrossBrowserBaseClass
{
    @Test
    public void addItemToCart()
    {
        au.clickOnElement(nav.getProductLink());

        au.clickOnElement(wbu.getDriver().findElement(By.xpath("//a[@href='/product_details/1']")));

        au.clickOnElement(wbu.getDriver().findElement(By.xpath("//button[@class='btn btn-default cart']")));
    }
}
