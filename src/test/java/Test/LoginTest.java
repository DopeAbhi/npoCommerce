package Test;

import PageObject.LoginPage;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void login()
    {
      LoginPage loginPage= page.LoginPageNavigation();

        loginPage.setEmailField("Test@yopmail.com");
        loginPage.setPasswordField("Test@123");
        loginPage.setRememberMe();
        loginPage.loginButtonClick();
        driver.quit();
    }



}
