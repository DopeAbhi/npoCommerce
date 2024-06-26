package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListingPage extends AbstractComponent {

    WebDriver driver;
    public ProductListingPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//div[@class='details']/h2")
    private List<WebElement> product;

    public ProductDetailsPage selectProduct(String productName)
    {
        for (WebElement element :product)
        {
            if (element.getText().contains(productName))
            {
                element.click();
            }
        }
        return new ProductDetailsPage(driver);
    }
}
