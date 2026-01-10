package baseclassPacckage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pompackage.NavBarPom;
import pompackage.SignUp_LogInPagePOM;
import utilitypackage.ActionUtility;
import utilitypackage.GlobalConfiguration;
import utilitypackage.WebBrowserUtility;

public class ParallelMethodBaseClass
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


    @BeforeMethod
    public void doConfiguration() throws Exception
    {
        gc = new GlobalConfiguration();
        browser = gc.getData("browser");
        url = gc.getData("url");
        user = gc.getData("user");
        password = gc.getData("password");

        wbu = new WebBrowserUtility();

        wbu.openBrowser(browser);
        //wbu.openUrl(url);

        wbu.getDriver().get("https://automationexercise.com/");
        wbu.waitForElement(10);

        au = new ActionUtility(wbu.getDriver());


        signUp = new SignUp_LogInPagePOM(wbu.getDriver());
        nav = new NavBarPom(wbu.getDriver());
    }
}
