package baseclassPacckage;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pompackage.NavBarPom;
import pompackage.SignUp_LogInPagePOM;
import utilitypackage.ActionUtility;
import utilitypackage.GlobalConfiguration;
import utilitypackage.WebBrowserUtility;

public class Registration_ExistingMailId_BaseClass
{
    public GlobalConfiguration gc;
    public WebBrowserUtility wbu;
    public ActionUtility au;

    public String browser;
    public String url;
    public String user;
    public String password;

    public SignUp_LogInPagePOM signUp;
    public NavBarPom nav;

    public WebDriver driver;

    @BeforeSuite
    public void loadConfiguration() throws Exception
    {
       gc = new GlobalConfiguration();
       browser = gc.getData("browser");
       url = gc.getData("url");
       user = gc.getData("user");
       password = gc.getData("password");
    }

    @BeforeTest
    public void doConfiguration()
    {
        wbu = new WebBrowserUtility();
        wbu.openBrowser(browser);
        wbu.openUrl(url);
        wbu.waitForElement(10);
        driver = wbu.getDriver();

        au = new ActionUtility(driver);

        signUp = new SignUp_LogInPagePOM(driver);
        nav = new NavBarPom(driver);

    }




}
