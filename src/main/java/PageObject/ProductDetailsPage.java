package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.IntStream;

public class ProductDetailsPage extends AbstractComponent {
    WebDriver driver ;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);


    }
    @FindBy(css =".product-title")
    private List<WebElement> itemTitle;

    @FindBy(css = "a[href*='/cart']")
    private WebElement cartNavigation;



    public void itemAdd(String itemName)
    {
        IntStream.range(0, itemTitle.size())
                .filter(i -> itemTitle.get(i).getText().contains(itemName))
                .findFirst() // Get the index of the first matching element
                .ifPresent(index -> {driver.findElements(By.cssSelector(".product-box-add-to-cart-button")).get(index).click();}
                );

    }

    public CartPage cartNavigationfromNotifications()
    {
        cartNavigation.click();
        return new CartPage(driver);
    }



}
