package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {


    WebDriver driver;
    public LandingPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void startPage()
    {
        driver.get("https://demo.nopcommerce.com/#");

    }

    @FindBy(css = ".ico-login")
    WebElement loginLink;
    public LoginPage LoginPageNavigation()
    {
        loginLink.click();
        return new LoginPage(driver);
    }
}