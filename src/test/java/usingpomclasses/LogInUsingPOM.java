package usingpomclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pompackage.LogInPagePOM;
import utilitypackage.ActionUtility;
import utilitypackage.PropertyFileUtilityClass;
import utilitypackage.WebBrowserUtility;

import java.time.Duration;

public class LogInUsingPOM
{
    static PropertyFileUtilityClass pfu;
    static WebBrowserUtility wbu;
    static ActionUtility au;

    static LogInPagePOM login;

    static String browser;
    static String url;
    static String user;
    static String password;

    static WebDriver driver;

    public static void main(String[] args)  throws Exception{

        pfu = new PropertyFileUtilityClass();

        browser = pfu.getData("browser");
        url = pfu.getData("url");
        user = pfu.getData("user");
        password = pfu.getData("password");

        wbu = new WebBrowserUtility();

        wbu.openBrowser(browser);
        wbu.openUrl(url);
        wbu.waitForElement(10);
        driver = wbu.getDriver();


        login = new LogInPagePOM(driver);

        au = new ActionUtility(driver);

        au.clearContent(login.getUserNameField());

        wbu.dumbWait(1);

        au.writeInElement(login.getUserNameField(),user);

        wbu.dumbWait(1);

        au.clearContent(login.getPasswordField());

        wbu.dumbWait(1);

        au.writeInElement(login.getPasswordField(),password);

        wbu.dumbWait(1);

        au.clickOnElement(login.getLogInButton());

    }
}
