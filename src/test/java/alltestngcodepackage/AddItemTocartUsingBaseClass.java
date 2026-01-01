package alltestngcodepackage;

import baseclassPacckage.AddItemToCartBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AddItemTocartUsingBaseClass extends AddItemToCartBaseClass
{
    @Test
    public void clickOnProduct()
    {
        au.scrollTillDesiredElement(wbu.getDriver().findElement(By.xpath("//img[@src='/get_product_picture/16']")));

//       au.clickOnElement(home.getFrozenTshirt());

        home.selectDesiredProduct(desiredProduct);

    }
}
