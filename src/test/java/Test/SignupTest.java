package Test;

import PageObject.SignupPage;
import TestComponents.BaseTest;
import jdk.jfr.Threshold;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignupTest extends BaseTest {

    @Test
    public void testSignup() throws InterruptedException {
        SignupPage page = new SignupPage(driver);
        page.signupPageNavigation();
        page.setGender();
        page.setFirstName("Tester");
        page.setLastName("Tester");
        page.setDOB(24,12,"1999");
        page.setEmail("Tester@yopmai.com");
        page.setCompanyName("TesterTester");
        page.setPassword("Test@123");
        page.setConfirmPassword("Test@123");
        page.registerButton();
        String message=page.messageVerification();
        Assert.assertTrue(message.equalsIgnoreCase("Your registration completed"));




    }
}
