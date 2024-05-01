package Test;

import PageObject.LoginPage;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login() throws InterruptedException {
      LoginPage loginPage= page.LoginPageNavigation();

        loginPage.setEmailField("Tester2@yopmail.com");
        loginPage.setPasswordField("Test@123");
        loginPage.setRememberMe();
        loginPage.loginButtonClick();
        Thread.sleep(2000);
        loginPage.selectItem("$25 Virtual Gift Card");
        Thread.sleep(3000);

        driver.quit();
    }



}
