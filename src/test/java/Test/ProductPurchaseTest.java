package Test;

import PageObject.CartPage;
import PageObject.CheckoutPage;
import PageObject.LoginPage;
import PageObject.ProductInfoPage;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class ProductPurchaseTest extends BaseTest {

    @Test
    public void testProductPurchase() throws InterruptedException {

        LoginPage loginPage= page.LoginPageNavigation();
        loginPage.setEmailField("Tester1@yopmail.com");
        loginPage.setPasswordField("Test@123");
        loginPage.setRememberMe();
        loginPage.loginButtonClick();

        //ProductInfoPage Handling
        ProductInfoPage infoPage=page.selectItem("$25 Virtual Gift Card");
        infoPage.setRecipientName("Tester");
        infoPage.setRecipientEmail("Tester2@yopmail.com");
        infoPage.setSenderName("TesterNew");
        infoPage.setSenderEmail("Tester@yopmail.com");
        infoPage.setMessageField("This gift only for you");
        infoPage.addItemtoCart();

        //Cart Page Handling
        CartPage cartPage =infoPage.cartNavigationfromAlert();
        cartPage.setTermsandService();
       CheckoutPage checkoutPage= cartPage.orderCheckoutButton();
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
       checkoutPage.continueButtonClick();
       checkoutPage.selectPaymentMethod("Cash");
       checkoutPage.continueButtonClick();
       Thread.sleep(3000);



    }


}
