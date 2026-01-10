package utilitypackage;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebBrowserUtility
{


   private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

   public WebDriver getDriver()
   {
       return tlDriver.get();
   }

    public void openBrowser(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
               tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","./msedgedriver.exe");
                tlDriver.set(new EdgeDriver());
                break;
            case "brave":
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:/Program Files/BraveSoftware/Brave-Browser/Application/brave.exe");
                tlDriver.set(new ChromeDriver(options));
                break;

            default: throw new InvalidArgumentException("The Browser Name is incorrect");
        }

        //getDriver().manage().window().maximize();
    }

    public void openUrl(String url)
    {
        getDriver().get(url);
    }

    public void waitForPageLoad(int num)
    {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(num));
    }

    public void waitForElement(int num)
    {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }

    public void closeBrowser()
    {
        if (getDriver()!=null)
        {
            getDriver().quit();
        }
    }

    public void dumbWait(int num) throws Exception
    {
        Thread.sleep(num*1000);
    }

}
