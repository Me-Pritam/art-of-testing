package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPagePOM
{
    @FindBy(css = "label[for='id_gender1']")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement signUpPasswordField;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@data-qa='address']")
    private WebElement address1Field;

    @FindBy(xpath = "//input[@data-qa='state']")
    private WebElement stateField;

    @FindBy(xpath = "//input[@data-qa='city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@data-qa='zipcode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//input[@data-qa='mobile_number']")
    private WebElement mobileNumberField;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    private WebElement createAccountButton;


    public SignUpPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getMaleRadioButton() {
        return maleRadioButton;
    }

    public WebElement getSignUpPasswordField() {
        return signUpPasswordField;
    }

    public WebElement getFirstNameField() {
        return firstNameField;
    }

    public WebElement getLastNameField() {
        return lastNameField;
    }

    public WebElement getAddress1Field() {
        return address1Field;
    }

    public WebElement getStateField() {
        return stateField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getZipCodeField() {
        return zipCodeField;
    }

    public WebElement getMobileNumberField() {
        return mobileNumberField;
    }

    public WebElement getCreateAccountButton() {
        return createAccountButton;
    }
}
