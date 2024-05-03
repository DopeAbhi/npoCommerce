package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponent
{
    WebDriver driver;
    public CartPage(WebDriver driver)
    {
        super (driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }
    @FindBy(css="[name='termsofservice']")
    WebElement termsandService;

    @FindBy(id="checkout")
    WebElement checkoutButton;

    public void setTermsandService()
    {
        termsandService.click();
    }

    public void orderCheckoutButton()
    {
        checkoutButton.click();
    }




}
