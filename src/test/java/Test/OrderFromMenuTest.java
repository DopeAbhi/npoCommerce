package Test;

import PageObject.*;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class OrderFromMenuTest extends BaseTest {

    @Test
    public void Order() throws InterruptedException {
    LoginPage loginPage= page.LoginPageNavigation();
        loginPage.setEmailField("Tester2@yopmail.com");
        loginPage.setPasswordField("Test@123");
        loginPage.setRememberMe();
        loginPage.loginButtonClick();
        ProductCategoryPage productCategoryPage= page.categoryfromMenu("Computers");

        ProductDetailsPage productDetailsPage= productCategoryPage.selectSubCategory("Notebooks");
        productDetailsPage.itemAdd("Samsung");
        Thread.sleep(2000);


        CartPage cartPage=productDetailsPage.cartNavigationfromNotifications();
        cartPage.setTermsandService();


        CheckoutPage checkoutPage= cartPage.orderCheckoutButton();
        String savedAddressStatus=checkoutPage.savedAddressCheck();

        if (savedAddressStatus.isEmpty()) {
            checkoutPage.setFirstName("FirstNameCheckout");
            checkoutPage.setLastName("LastNameCheckout");
            checkoutPage.setEmail("EmailCheckout@yopmail.com");
            checkoutPage.setCompanyName("Company Name Checkout");
            checkoutPage.selectCountry("India");

            checkoutPage.setCityField("Lucknow");
            checkoutPage.setFirstAddress("First Address Checkout");
            checkoutPage.setSecondAddress("SecondAddress Checkout");
            checkoutPage.setZipCode("123456");
            checkoutPage.setPhoneNumber("1234567890");
            checkoutPage.setFaxNumberField("17809902112");
            checkoutPage.continueButtonClick(0);
            checkoutPage.selectPaymentMethod("Cash");
            checkoutPage.continueButtonClick(0);
            Thread.sleep(3000);
            checkoutPage.selectShippingMethod();
            checkoutPage.continueButtonClick(2);
        }

        else
        {
            checkoutPage.continueButtonClick(0);
        }




        Thread.sleep(3000);


        driver.quit();


    }
}
