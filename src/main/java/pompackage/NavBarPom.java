package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBarPom
{
    @FindBy(xpath = "//img[contains(@alt,'Website for automation practice')]")
    private WebElement automationExcersizeLink;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    private WebElement homePageLink;

    @FindBy(xpath = "//a[contains(text(),'Cart')]")
    private WebElement cartPageLink;

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement logInSignUpLink;

    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productLink;



    public NavBarPom(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getAutomationExcersizeLink() {
        return automationExcersizeLink;
    }

    public WebElement getHomePageLink() {
        return homePageLink;
    }

    public WebElement getCartPageLink() {
        return cartPageLink;
    }

    public WebElement getLogInSignUpLink() {
        return logInSignUpLink;
    }

    public WebElement getProductLink() {
        return productLink;
    }
}
