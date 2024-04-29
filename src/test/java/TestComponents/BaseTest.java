package TestComponents;

import PageObject.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseTest {

  public  WebDriver driver;
  public  LandingPage page;

    public void driverInitalize(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize(); //Opening Browser in Maximize Mode

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() {
        driverInitalize("Chrome");
        page = new LandingPage(driver);
        page.startPage();
        return page;
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}
