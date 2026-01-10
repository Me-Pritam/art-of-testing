package baseclassPacckage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pompackage.NavBarPom;
import pompackage.SignUp_LogInPagePOM;
import utilitypackage.ActionUtility;
import utilitypackage.GlobalConfiguration;
import utilitypackage.WebBrowserUtility;

public class CrossBrowserBaseClass
{
    public GlobalConfiguration gc;
    public WebBrowserUtility wbu;
    public ActionUtility au;

    public String url;
    public String user;
    public String password;

    public SignUp_LogInPagePOM signUp;
    public NavBarPom nav;

    @Parameters("browser")
    @BeforeTest
    public void OpenBrowser(String browser) throws Exception
    {
        gc = new GlobalConfiguration();
        url = gc.getData("url");
        user = gc.getData("user");
        password = gc.getData("password");

        wbu = new WebBrowserUtility();
        wbu.openBrowser(browser);
        wbu.openUrl(url);
        wbu.waitForElement(10);

        signUp = new SignUp_LogInPagePOM(wbu.getDriver());
        nav = new NavBarPom(wbu.getDriver());
        au = new ActionUtility(wbu.getDriver());

        au.clickOnElement(nav.getLogInSignUpLink());

        signUp.performLogIn(user,password);
    }
}
