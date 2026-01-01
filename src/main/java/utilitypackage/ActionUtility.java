package utilitypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionUtility
{
    WebDriver driver;

    Actions action;

    public ActionUtility(WebDriver driver)
    {
        this.driver = driver;
        action = new Actions(driver);

    }

    public void writeInElement(WebElement element, String data)
    {
        action.pause(Duration.ofSeconds(2)).sendKeys(element,data).perform();
    }

    public void clickOnElement(WebElement element)
    {
        action.pause(Duration.ofSeconds(2)).click(element).perform();
    }

    public void clearContent(WebElement element) throws Exception
    {
        Thread.sleep(1000);
        element.clear();
    }

    public void scrollTillDesiredElement(WebElement element)
    {
        action.pause(Duration.ofSeconds(2)).scrollToElement(element).perform();
    }
}
