package baseclassPacckage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import pompackage.NavBarPom;
import pompackage.SignUp_LogInPagePOM;
import utilitypackage.ActionUtility;
import utilitypackage.GlobalConfiguration;
import utilitypackage.WebBrowserUtility;

public class ParallelClassBaseClass
{
    public GlobalConfiguration gc;
    public WebBrowserUtility wbu;
    public ActionUtility au;

    public static String browser;
    public String url;
    public String user;
    public String password;

    public SignUp_LogInPagePOM signUp;
    public NavBarPom nav;



    @BeforeClass
    public void doLogIn() throws Exception
    {
        gc = new GlobalConfiguration();
        browser = gc.getData("browser");
        url = gc.getData("url");
        user = gc.getData("user");
        password = gc.getData("password");

        wbu = new WebBrowserUtility();
        wbu.openBrowser(browser);
        wbu.openUrl(url);
        wbu.waitForElement(15) ;
        signUp = new SignUp_LogInPagePOM(wbu.getDriver());
        nav = new NavBarPom(wbu.getDriver());

        au = new ActionUtility(wbu.getDriver());

        au.clickOnElement(nav.getLogInSignUpLink());
        au.writeInElement(signUp.getLogInEmailField(),user);
        au.writeInElement(signUp.getLogInPasswordField(),password);
        au.clickOnElement(signUp.getLogInButton());


    }
}
