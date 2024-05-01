package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends AbstractComponent {
  WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }



    @FindBy(css="input[name='Email']")
    WebElement emailField;

    @FindBy(id = "Password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement rememberMe;

    @FindBy(css = ".button-1.login-button")
    WebElement submitButton;



    @FindBy (css = "div[class='details'] h2 a")
    List<WebElement> itemTitle;


    public void selectItem(String productName)
    {
        itemTitle.stream().filter(element->element.getText().equalsIgnoreCase(productName) ).forEach(element->element.findElement(By.cssSelector(".button-2.product-box-add-to-cart-button")).click());

//        for(WebElement element:itemTitle)
//        {
//           if(element.getText().equalsIgnoreCase(productName));
//             element.findElement(By.cssSelector(".button-2.product-box-add-to-cart-button")).click();
//
//        }
    }

    public  void setEmailField(String userEmail)
    {
        emailField.sendKeys(userEmail);
    }
    public  void setPasswordField(String userPassword)
    {
        passwordField.sendKeys(userPassword);
    }
    public void setRememberMe()
    {
        rememberMe.click();
    }

    public void loginButtonClick()
    {
        submitButton.click();
    }


















}
