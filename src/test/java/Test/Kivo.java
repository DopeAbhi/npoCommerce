package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class Kivo {

    @Test
    public void actionDemo() throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
            driver.manage().window().maximize();
            driver.get("https://www.kivo.ai/users/sign_in");
            driver.findElement(By.id("user_email")).sendKeys("ajeet.singh@w3villa.com");
            driver.findElement(By.id("password")).sendKeys("Ajtsimmpli@123");
            driver.findElement(By.name("commit")).click();
            //driver.findElement(By.xpath(“//button[@data-toggle=‘fullscreen’]“)).click();
        Thread.sleep(4000);

//           wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".caret.pull-right"))).wait();
            driver.findElement(By.cssSelector(".caret.pull-right")).click();
            Thread.sleep(3000);

            driver.quit();

    }
}
