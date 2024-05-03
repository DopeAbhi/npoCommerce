package Test;

import PageObject.LoginPage;
import PageObject.ProductInfoPage;
import TestComponents.BaseTest;
import org.testng.annotations.Test;

public class ProductPurchaseTest extends BaseTest {

    @Test
    public void testProductPurchase()  {
        LoginPage loginPage= page.LoginPageNavigation();
        loginPage.setEmailField("Tester@yopmail.com");
        loginPage.setPasswordField("Test@123");
        loginPage.setRememberMe();
        loginPage.loginButtonClick();
        ProductInfoPage infoPage=page.selectItem("$25 Virtual Gift Card");
        infoPage.setRecipientName("Tester");
        infoPage.setRecipientEmail("Tester2@yopmail.com");
        infoPage.setSenderName("TesterNew");
        infoPage.setSenderEmail("Tester@yopmail.com");
        infoPage.setMessageField("This gift only for you");
        infoPage.addItemtoCart();
        infoPage.cartNavigationfromAlert();


    }


}
