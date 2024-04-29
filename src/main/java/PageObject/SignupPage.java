package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SignupPage {

    @FindBy(className = "ico-register")
    WebElement signUpLink;

    @FindBy(css = "[value='M']")
    WebElement gender;

    @FindBy(css = "[name='FirstName']")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement lastName;

    @FindBy(xpath = "//select[@name='DateOfBirthDay']/option")
    List <WebElement> day;
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']/option")
    List<WebElement> month;
    @FindBy(xpath = "//select[@name='DateOfBirthYear']/option")
    List<WebElement> year;

    public void signUpPageNavigation()
    {
        signUpLink.click();
    }

    public void setGender()
    {
        gender.click();
    }

    public void setFirstName(String fname)
    {
        firstName.sendKeys(fname);
    }
    public void setLastName(String lname)
    {
        lastName.sendKeys(lname);
    }

    public void setDateOfBirth()
    {

    }

}
