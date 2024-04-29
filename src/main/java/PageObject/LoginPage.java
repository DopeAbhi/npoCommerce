package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginPage {
  WebDriver driver;
    public LoginPage(WebDriver driver)
    {
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
