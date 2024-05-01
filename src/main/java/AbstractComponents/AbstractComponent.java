package AbstractComponents;

import PageObject.LoginPage;
import PageObject.SignupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {

WebDriver driver;
public AbstractComponent(WebDriver driver)
{
   this.driver=driver;
    PageFactory.initElements(driver, this);
}
    @FindBy(css = ".ico-register")
    WebElement signUp;


    @FindBy(css = ".ico-login")
    WebElement loginLink;
    public SignupPage signupPageNavigation()
    {
        signUp.click();
        return new SignupPage(driver);
    }

    public LoginPage LoginPageNavigation()
    {
        loginLink.click();
        return new LoginPage(driver);
    }










}
