package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage extends AbstractComponent
{
   WebDriver driver;
    public ProductInfoPage(WebDriver driver) {

        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css=".recipient-name")
    WebElement recipientNameField;

    @FindBy(id = "giftcard_43_RecipientEmail")
    WebElement recipientEmailField;

    @FindBy(css = ".sender-name")
    WebElement senderNameField;

    @FindBy(css = ".sender-email")
    WebElement senderEmailField;

    @FindBy(css = "#giftcard_43_Message")
    WebElement messageField;

    @FindBy(css="#add-to-cart-button-43")
    WebElement addToCartButton;

    public void setRecipientName(String recipientName)
    {
        recipientNameField.sendKeys(recipientName);
    }
    public void setRecipientEmail(String recipientEmail)
    {
        recipientEmailField.sendKeys(recipientEmail);
    }
    public void setSenderName(String senderName)
    {
        senderNameField.sendKeys(senderName);
    }
    public void setSenderEmail(String senderEmail)
    {
        senderEmailField.sendKeys(senderEmail);
    }
    public void setMessageField(String message)
    {
        messageField.sendKeys(message);
    }

    public void addItemtoCart()
    {
        addToCartButton.click();
    }



}
