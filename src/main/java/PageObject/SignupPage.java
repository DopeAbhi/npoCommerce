package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SignupPage extends AbstractComponent {

public WebDriver driver;
public SignupPage(WebDriver driver)
{
    super(driver);
    this.driver = driver;
    PageFactory.initElements(driver, this);
}



@FindBy(css="[value='M']")
    WebElement genderSelection;

@FindBy(css="#FirstName")
    WebElement fNameField ;

@FindBy(css="#LastName")
    WebElement lNameField ;

@FindBy(xpath = "//select[@name='DateOfBirthDay']/option")
List <WebElement> Day;

@FindBy(xpath = "//select[@name='DateOfBirthMonth']/option")
List <WebElement> Month;

@FindBy(xpath = "//select[@name='DateOfBirthYear']")
WebElement Year;

@FindBy(css="[name='Email']")
WebElement emailField;

@FindBy(css="#Company")
WebElement companyField;

@FindBy(css="[name='Password']")
WebElement passwordField;

@FindBy(css="[name='ConfirmPassword']")
WebElement confirmPasswordField;

@FindBy(css="[name='register-button']")
WebElement submitButton;

@FindBy(css="div[class='result']")
WebElement successMessage;


public void setGender()
{
    genderSelection.click();
}
public void setFirstName(String firstName)
{
    fNameField.sendKeys(firstName);
}
public void setLastName(String lastName)
{
    lNameField.sendKeys(lastName);
}

public void setDOB(int day, int month, String year)
{
    Day.get(day).click();
    Month.get(month).click();
    Select select= new Select(Year);
    select.selectByVisibleText(year);
}

public void setEmail(String email)
{
    emailField.sendKeys(email);
}

public void setCompanyName(String companyName)
{
    companyField.sendKeys(companyName);
}
    public void setPassword(String password)
{
    passwordField.sendKeys(password);
}

public void setConfirmPassword(String confirmPassword)
{
    confirmPasswordField.sendKeys(confirmPassword);
}

public void registerButton()
{
    submitButton.click();
}

public String messageVerification()
{
    return successMessage.getText();
}

}
