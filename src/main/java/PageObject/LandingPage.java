package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.IntStream;

public class LandingPage extends AbstractComponent {


    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;

        PageFactory.initElements(driver,this);

    }

    public void startPage()
    {
        driver.get("https://demo.nopcommerce.com/#");

    }

    @FindBy (xpath = "//div[@class='details']/h2/a")
    List<WebElement> itemTitle;

    @FindBy(css = "[class='header-menu'] ul li a")
    List<WebElement> topMenu;


    public ProductInfoPage selectItem(String productName) {

        IntStream.range(0, itemTitle.size())
                .filter(i -> itemTitle.get(i).getText().equalsIgnoreCase(productName))
                .findFirst() // Get the index of the first matching element
                .ifPresent(index -> {driver.findElements(By.cssSelector(".button-2.product-box-add-to-cart-button")).get(index).click();}
                );
        return new ProductInfoPage(driver);

    }

    public ProductCategoryPage categoryfromMenu(String category)
    {

        for (WebElement element :topMenu)
        {

            if(element.getText().equalsIgnoreCase(category))
            {
                explicitWait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;
            }
        }
        return new ProductCategoryPage(driver);
    }



}
