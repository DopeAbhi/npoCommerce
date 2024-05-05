package AbstractComponents;

import PageObject.LoginPage;
import PageObject.SignupPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AbstractComponent {

WebDriver driver;
public AbstractComponent(WebDriver driver)
{
   this.driver=driver;
    PageFactory.initElements(driver, this);
}
    @FindBy(css = ".ico-register")
   private WebElement signUp;


    @FindBy(css = ".ico-login")
    private WebElement loginLink;

    @FindBy(css = "div[class='footer-upper'] div ul li a")
   private List<WebElement> footerLinks;


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

    public List<Object> footerLinksVerify() throws IOException {
        List<int> code=new ArrayList<int>();


        for (WebElement list:footerLinks) {

            HttpURLConnection connection =(HttpURLConnection) new URL(list.getAttribute("href")).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            code.add(connection.getResponseCode());


        }
        return code;

    }












}
