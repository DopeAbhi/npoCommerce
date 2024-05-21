package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends AbstractComponent {
    WebDriver driver ;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);


    }

    @FindBy (css = ".add-to-cart-button")
    private WebElement addToCartButton;


    public void addProductToCart()
    {
        addToCartButton.click();
    }
}
