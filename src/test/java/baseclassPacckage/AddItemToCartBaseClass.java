package baseclassPacckage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pompackage.CartPagePOM;
import pompackage.HomePagePOM;
import pompackage.NavBarPom;
import pompackage.SignUp_LogInPagePOM;
import utilitypackage.ActionUtility;
import utilitypackage.GlobalConfiguration;
import utilitypackage.WebBrowserUtility;

public class AddItemToCartBaseClass
{
    public String browser;
    public String password;
    public String url;
    public String user;
    public String desiredProduct;

    public HomePagePOM home;
    public NavBarPom navBar;
    public SignUp_LogInPagePOM logInSignUp;
    public CartPagePOM cart;

    public GlobalConfiguration gc;
    public WebBrowserUtility wbu;
    public ActionUtility au;

    @BeforeSuite
    public void loadConfig() throws Exception
    {
       gc = new GlobalConfiguration();

       browser = gc.getData("browser");
       url = gc.getData("url");
       user = gc.getData("user");
       password = gc.getData("password");
       desiredProduct = gc.getData("desiredProduct");


    }

    @BeforeTest
    public void doConfig()
    {
        wbu = new WebBrowserUtility();

        wbu.openBrowser(browser);
        wbu.openUrl(url);
        wbu.waitForElement(10);

        au = new ActionUtility(wbu.getDriver());

        logInSignUp = new SignUp_LogInPagePOM(wbu.getDriver());
        navBar = new NavBarPom(wbu.getDriver());
        home = new HomePagePOM(wbu.getDriver());
        cart = new CartPagePOM(wbu.getDriver());

    }

    @BeforeClass(enabled = false)
    public void doLogIn()
    {
        au.clickOnElement(navBar.getLogInSignUpLink());
        au.writeInElement(logInSignUp.getLogInEmailField(),user);
        au.writeInElement(logInSignUp.getLogInPasswordField(),password);
        au.clickOnElement(logInSignUp.getLogInButton());

    }

}
