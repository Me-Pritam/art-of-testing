package ddtpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class PerformLogInUsingPropertyFile
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

            System.out.println(password);


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

            WebElement userNameField = driver.findElement(By.xpath("//input[@id='uname']"));
            WebElement passwordField = driver.findElement(By.xpath("//input[@id='pass']"));
            WebElement logInButton = driver.findElement(By.xpath("//button[text()='Login']"));

            userNameField.clear();
            Thread.sleep(1000);
            userNameField.sendKeys(user);
            Thread.sleep(1000);
            passwordField.clear();
            Thread.sleep(1000);
            passwordField.sendKeys(password);
            Thread.sleep(1000);
            logInButton.click();







        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
