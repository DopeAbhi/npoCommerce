package Test;

import PageObject.LoginPage;
import PageObject.ProductCategoryPage;
import PageObject.ProductDetailsPage;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class OrderFromMenuTest extends BaseTest {

    @Test
    public void Order() throws InterruptedException {
    LoginPage loginPage= page.LoginPageNavigation();
        loginPage.setEmailField("Tester1@yopmail.com");
        loginPage.setPasswordField("Test@123");
        loginPage.setRememberMe();
        loginPage.loginButtonClick();
       ProductCategoryPage productCategoryPage= page.categoryfromMenu("Computers");
       ProductDetailsPage productDetailsPage= productCategoryPage.selectSubCategory("Notebooks");
       productDetailsPage.addProductToCart();


        driver.quit();


    }
}
