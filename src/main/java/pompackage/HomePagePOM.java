package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;
import java.util.List;

public class HomePagePOM
{
    WebDriver driver;

    @FindBy(xpath = "//div[@class='productinfo text-center']")
    private List<WebElement> allProducts;

    @FindBy(xpath = "//div[@class='signup-form']/descendant::h2")
    private WebElement newUserSignUpHeading;



    @FindBy(xpath = "//a[@data-product-id='13' and @class='btn btn-default add-to-cart']")
        private WebElement frozenTshirt;

        public HomePagePOM(WebDriver driver)
        {
            this.driver = driver;

            PageFactory.initElements(driver,this);
        }



//    public void selectDesiredProduct(String prodName) {
//        for (WebElement product : allProductName) {
//            // Extract product name from within current product div
//
//            String productPath = product.toString().replaceFirst("]$","").split("-> xpath: ")[1];
//            String productName = product.getText();
//            System.out.println(productPath);
//
//            if (productName.contains(prodName)) {
//                // Click Add to cart button within the matching product
//                WebElement viewProductBtn = product.findElement(By.xpath(productPath+"/following::a[contains(@href,'/product_details/')]"));
//                viewProductBtn.click();
//                System.out.println("Added product: " + prodName + " to cart");
//                return; // Exit after successful click
//            }
//        }
//        throw new RuntimeException("Product '" + prodName + "' not found");
//    }

    public void selectDesiredProduct(String prodName) {

        for (WebElement product : allProducts) {

            String productName = product.findElement(By.tagName("p")).getText();

            System.out.println(productName);

            if (productName.equalsIgnoreCase(prodName)) {

                (new Actions(driver)).moveToElement(product)
                                     .pause(Duration.ofSeconds(2))
                                     .click(product.findElement(By.xpath("//a[contains(@href,'/product_details')]")))
                                     .perform();

                System.out.println("Clicked product: " + prodName);
                return;
            }
        }

        throw new RuntimeException("Product '" + prodName + "' not found");
    }

    public WebElement getNewUserSignUpHeading()
    {
        return newUserSignUpHeading;
    }


//    public List<WebElement> getAllProduct() {
//        return allProductName;
//    }
//
//    public WebElement getFrozenTshirt() {
//        return frozenTshirt;
//    }
}
