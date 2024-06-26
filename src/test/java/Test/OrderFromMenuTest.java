package Test;

import PageObject.*;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class OrderFromMenuTest extends BaseTest {

    @Test
    public void Order() throws InterruptedException {

      String PaymentMethod="Credit Card";
    LoginPage loginPage= page.LoginPageNavigation();
        loginPage.setEmailField("Tester3@yopmail.com");
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
        Boolean savedAddressStatus=checkoutPage.savedAddressCheck();

        if (savedAddressStatus) {
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

        }


            checkoutPage.continueButtonClick(0);
        Thread.sleep(3000);

            checkoutPage.selectShippingMethod();
            checkoutPage.continueButtonClick(2);
            checkoutPage.selectPaymentMethod(PaymentMethod);
            checkoutPage.continueButtonClick(3);

            if (PaymentMethod.contains("Credit"))
            {
                checkoutPage.setCreditCard("MasterCard");
                checkoutPage.setCardholderName("TestHacker");
                checkoutPage.setCardNumber("5555555555554444");
                checkoutPage.setCardExpireMonth("12");
                checkoutPage.setCardExpireYear("2027");
                checkoutPage.setCardCode("123");

            }
        checkoutPage.continueButtonClick(4);
            checkoutPage.confirmButtonClick();




        Thread.sleep(3000);


        driver.quit();


    }
}
