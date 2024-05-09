package Test;

import PageObject.LandingPage;
import Resources.UrlResponsePair;
import TestComponents.BaseTest;
import com.google.j2objc.annotations.OnDealloc;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class FooterLinksTest  extends BaseTest {


    @Test
    public void linkTest() throws IOException {


       List<UrlResponsePair> responseCode= page.footerLinksVerify();
        SoftAssert softAssert=new SoftAssert();
       for (UrlResponsePair code:responseCode)
       {
           softAssert.assertTrue(code.getResponseCode()<300,code.getLinkName());

       }
       softAssert.assertAll();


    }
}
