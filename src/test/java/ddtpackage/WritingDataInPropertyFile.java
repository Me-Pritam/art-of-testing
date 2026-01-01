package ddtpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

public class WritingDataInPropertyFile
{
    public static String browser;
    public static String url ;
    public static String user;
    public static String password;

    public static WebDriver driver;

    public static void main(String[] args) {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/CommondataFolder/ArtOfTestingProperty.properties");

            Properties property = new Properties();

            property.load(fis);

            browser = property.getProperty("browser");
            url = property.getProperty("url");
            user = property.getProperty("user");
            password = property.getProperty("password");

            switch (browser.toLowerCase())
            {
                case "chrome":
                    driver = new ChromeDriver();
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    System.setProperty("webdriver.edge.driver","./msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;

                default: throw new InvalidArgumentException("Please provide proper browser name");
            }

            driver.manage().window().maximize();

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            driver.get(url);

            driver.findElement(By.xpath("//button[text()='Login']")).click();

           List<WebElement> allBookNames =  driver.findElements(By.xpath("//div[@class='Products_item__Za1Q4']/descendant::div[@class='Products_title__7ggYL']"));

           for(int i=0; i<allBookNames.size();i++)
           {
               property.setProperty("book"+(i+1),allBookNames.get(i).getText());
           }

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestdataFolder/ArtOfTestingProperty.properties");

            property.remove("book2");

           property.store(fos,"Updated By DemoName");

           fos.close();

            Thread.sleep(1000);




        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
