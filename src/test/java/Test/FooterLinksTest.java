package Test;

import PageObject.LandingPage;
import TestComponents.BaseTest;
import com.google.j2objc.annotations.OnDealloc;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class FooterLinksTest  extends BaseTest {


    @Test
    public void linkTest() throws IOException {
       List<Object> responseCode= page.footerLinksVerify();
        SoftAssert softAssert=new SoftAssert();
       for (Object code:responseCode)
       {
           softAssert.assertTrue(int(code)<300,"Link Broken");

       }


    }
}
