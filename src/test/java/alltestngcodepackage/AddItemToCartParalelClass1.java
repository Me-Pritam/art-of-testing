package alltestngcodepackage;

import baseclassPacckage.ParallelClassBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class AddItemToCartParalelClass1 extends ParallelClassBaseClass
{
    WebDriver driver ;

    @Test
    public void addItemToCart()
    {
       //driver = wbu.getDriver();

        au.clickOnElement(nav.getProductLink());

        au.clickOnElement(wbu.getDriver().findElement(By.xpath("//a[@href='/product_details/1']")));

        au.clickOnElement(wbu.getDriver().findElement(By.xpath("//button[contains(@class,'btn btn-default cart')]")));
    }

}
