package pompackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp_LogInPagePOM
{
    WebDriver driver;

    private static final Logger log = LogManager.getLogger(SignUp_LogInPagePOM.class);
    @FindBys({@FindBy(xpath = "//input[@data-qa='signup-name']"),@FindBy(xpath = "//input[@placeholder='Name']")})
    private WebElement signUpUserNameField;

    @FindBys({@FindBy(xpath = "//input[@placeholder='Email Address']"),@FindBy(xpath = "//input[@data-qa='signup-email']")})
    private WebElement signUpEmailField;

    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement signUpButton;

    @FindBys({@FindBy(xpath = "//input[@placeholder='Email Address']"),@FindBy(xpath = "//input[@data-qa='login-email']")})
    private WebElement logInEmailField;

    @FindAll({@FindBy(xpath = "//input[@name='password']"),@FindBy(xpath = "//input[@placeholder='Password']")})
    private WebElement logInPasswordField;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement logInButton;


    public SignUp_LogInPagePOM(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterSignUpPage(String name, String email)
    {
        signUpUserNameField.sendKeys(name);
        signUpEmailField.sendKeys(email);
        signUpButton.click();
    }

    public void performLogIn(String email,String password)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(logInEmailField)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(logInPasswordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(logInButton)).click();
    }

    public WebElement getSignUpUserNameField() {
        return signUpUserNameField;
    }

    public WebElement getSignUpEmailField() {
        return signUpEmailField;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getLogInEmailField() {
        return logInEmailField;
    }

    public WebElement getLogInPasswordField() {
        return logInPasswordField;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }
}
