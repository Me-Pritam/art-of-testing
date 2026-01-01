package usingutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilitypackage.ActionUtility;
import utilitypackage.PropertyFileUtilityClass;
import utilitypackage.WebBrowserUtility;

import java.util.List;

public class AddBookInCartUsingUtility
{
    public static String browser;
    public static String url;
    public static String desiredBook;

    static PropertyFileUtilityClass pfu;
    static WebBrowserUtility wbu;
    static ActionUtility au;

    static WebDriver driver;

    public static void main(String[] args)
    {
        try
        {
            pfu = new PropertyFileUtilityClass();
            browser = pfu.getData("browser");
            url = pfu.getData("url");
            desiredBook = pfu.getData("desir+edBook");

            wbu = new WebBrowserUtility();

            wbu.openBrowser(browser);
            wbu.waitForPageLoad(10);
            wbu.openUrl(url);
            wbu.waitForElement(10);

            driver = wbu.getDriver();

            au = new ActionUtility(driver);

            au.clickOnElement(driver.findElement(By.xpath("//button[text()='Login']")));


           List<WebElement> allBooks = driver.findElements(By.xpath("//div[@class='Products_item__Za1Q4']"));

           for (WebElement book: allBooks)
           {
               String bookName = book.findElement(By.xpath(".//div[@class='Products_title__7ggYL']")).getText();

               if (bookName.equals(desiredBook))
               {
                   au.clickOnElement(book.findElement(By.xpath(".//button[text()='Add To Cart']")));
                   break;
               }

           }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

}
