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

      SignupPage signupPage=  page.signupPageNavigation();
        signupPage.setGender();
        signupPage.setFirstName("Tester");
        signupPage.setLastName("Tester");
        signupPage.setDOB(24,12,"1999");
        signupPage.setEmail("Tester3@yopmail.com");
        signupPage.setCompanyName("TesterTester");
        signupPage.setPassword("Test@123");
        signupPage.setConfirmPassword("Test@123");
        signupPage.registerButton();
        String message=signupPage.messageVerification();
        Assert.assertTrue(message.equalsIgnoreCase("Your registration completed"));




    }
}
