package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPagePOM
{
    @FindBy(xpath = "//table[@id='cart_info_table']/descendant::td[@class='cart_product']/descendant::img")
    private List<WebElement>  allProductImage;

    @FindBy(xpath = "//table[@id='cart_info_table']/descendant::td[@class='cart_description']/descendant::a")
    private List<WebElement> allProductDescription;

    @FindBy(xpath = "//table[@id='cart_info_table']/descendant::td[@class='cart_price']/descendant::p")
    private List<WebElement> getAllProductPrice;

    @FindBy(xpath = "//table[@id='cart_info_table']/descendant::td[@class='cart_quantity']/child::button")
    private List<WebElement> allProductQuantity;

    @FindBy(xpath = "//table[@id='cart_info_table']/descendant::td[@class='cart_total']/child::p")
    private List<WebElement> allProductPrice;

    @FindBy(xpath = "//table[@id='cart_info_table']/descendant::td[@class='cart_delete']/child::a")
    private List<WebElement> allProductCancelButton;

    @FindBy(xpath = "//a[text()='Proceed To Checkout']")
    private WebElement proceedToCheckoutButton;

    public  CartPagePOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getAllProductImage() {
        return allProductImage;
    }

    public List<WebElement> getAllProductDescription() {
        return allProductDescription;
    }

    public List<WebElement> getGetAllProductPrice() {
        return getAllProductPrice;
    }

    public List<WebElement> getAllProductQuantity() {
        return allProductQuantity;
    }

    public List<WebElement> getAllProductPrice() {
        return allProductPrice;
    }

    public List<WebElement> getAllProductCancelButton() {
        return allProductCancelButton;
    }

    public WebElement getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }
}
