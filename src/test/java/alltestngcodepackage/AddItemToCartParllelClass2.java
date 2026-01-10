package alltestngcodepackage;

import baseclassPacckage.ParallelClassBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AddItemToCartParllelClass2  extends ParallelClassBaseClass
{
    WebDriver driver;

    @Test
    public void addItemToCart()
    {
        driver = wbu.getDriver();
        au.clickOnElement(wbu.getDriver().findElement(By.xpath("//a[@href='/product_details/2']")));
        au.clickOnElement(wbu.getDriver().findElement(By.xpath("//button[contains(@class,'btn btn-default cart')]")));
    }
}
