package Test;

import PageObject.*;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class OrderFromMenuTest extends BaseTest {

    @Test
    public void Order() throws InterruptedException {

      String PaymentMethod="Credit Card";

       //Login in the Page After for the Order
        LoginPage loginPage= page.LoginPageNavigation();
        loginPage.setEmailField("Tester3@yopmail.com");
        loginPage.setPasswordField("Test@123");
        loginPage.setRememberMe();
        loginPage.loginButtonClick();

        //Navigating to the Product Category Page
        ProductCategoryPage productCategoryPage= page.categoryfromMenu("Computers");

        //Adding Item to the Cart
        ProductDetailsPage productDetailsPage= productCategoryPage.selectSubCategory("Notebooks");
        productDetailsPage.itemAdd("Samsung");

        //Navigating to the Cart
        CartPage cartPage=productDetailsPage.cartNavigationfromNotifications();
        cartPage.setTermsandService();

        //Order Checkout
        CheckoutPage checkoutPage= cartPage.orderCheckoutButton();
        Boolean savedAddressStatus=checkoutPage.savedAddressCheck();

        //Completing the Order with the Check that we have saved address or not.

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


            checkoutPage.selectShippingMethod();
            checkoutPage.continueButtonClick(2);
            checkoutPage.selectPaymentMethod(PaymentMethod);
            checkoutPage.continueButtonClick(3);

            if (PaymentMethod.contains("Credit"))
            {
                checkoutPage.setCreditCard("Master card");
                checkoutPage.setCardholderName("TestHacker");
                checkoutPage.setCardNumber("5555555555554444");
                checkoutPage.setCardExpireMonth("12");
                checkoutPage.setCardExpireYear("2027");
                checkoutPage.setCardCode("123");

            }
            checkoutPage.continueButtonClick(4);
            checkoutPage.confirmButtonClick();
            String orderText=checkoutPage.getOrderNumber();
            String[] orderID=orderText.trim().split(":");
            System.out.println(orderID[1].trim());







        driver.quit();


    }
}
