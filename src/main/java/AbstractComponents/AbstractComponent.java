package AbstractComponents;

import PageObject.LoginPage;
import PageObject.SignupPage;
import Resources.UrlResponsePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AbstractComponent {

public WebDriver driver;
    public WebDriverWait explicitWait;

public AbstractComponent(WebDriver driver)
{
   this.driver=driver;
    PageFactory.initElements(driver, this);
    explicitWait =new WebDriverWait(this.driver,Duration.ofSeconds(5));

}

    @FindBy(css = ".ico-register")
   private WebElement signUp;


    @FindBy(css = ".ico-login")
    private WebElement loginLink;

    @FindBy(css = "div[class='footer-upper'] div ul li a")
   private List<WebElement> footerLinks;

    @FindBy (css = "div[class='header-menu'] ul:first-child li")
    private List<WebElement> topMenuLinks;



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

    public List<UrlResponsePair> footerLinksVerify() throws IOException {
        List<UrlResponsePair> codes = new ArrayList<>();


        for (WebElement list:footerLinks) {



            HttpURLConnection connection =(HttpURLConnection) new URL(list.getAttribute("href")).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            codes.add(new UrlResponsePair(connection.getResponseCode(),list.getText()));


        }
        return codes;

    }

    public void selectMethod(WebElement element,String text)
    {
        Select dropdown=new Select(element);
       dropdown.selectByVisibleText(text);
    }














}
