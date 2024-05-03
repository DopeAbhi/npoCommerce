package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        super (driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "#BillingNewAddress_FirstName")
    WebElement firstNameField;

    @FindBy(css="#BillingNewAddress_LastName")
    WebElement lastNameField;

    @FindBy(css="[name='BillingNewAddress.Email']")
    WebElement emailField;

    @FindBy(css="[name='BillingNewAddress.Company']")
    WebElement companyNameField;

    @FindBy(css="[data-trigger='country-select']")
    WebElement countryDropDown;

    @FindBy(css="[data-trigger='state-select']")
    WebElement stateDropDown;

    @FindBy(css="#BillingNewAddress_City")
    WebElement cityField;

    @FindBy(css="[name='BillingNewAddress.Address1']")
    WebElement firstAddressField;

    @FindBy(css="[name='BillingNewAddress.Address2']")
    WebElement secondAddressField;

    @FindBy(css="[name='BillingNewAddress.ZipPostalCode']")
    WebElement zipCodeField;

    @FindBy(css="[name='BillingNewAddress.PhoneNumber']")
    WebElement phoneNumberField;

    @FindBy(css="#BillingNewAddress_FaxNumber")
    WebElement faxNumberField;

    @FindBy(css=".new-address-next-step-button")
    WebElement continueButton;


    public void  setFirstName(String firstName)
    {
        firstNameField.sendKeys(firstName);
    }
    public  void setLastName(String lastName)
    {
        lastNameField.sendKeys(lastName);
    }

    public void setEmail(String email)
    {
        if(emailField.getText()==null ||emailField.getText().isEmpty())
        {
            emailField.sendKeys(email);
        }
    }

    public void setCompanyName(String companyName)
    {
        companyNameField.sendKeys(companyName);
    }

    public void selectCountry(String countryName){

        Select dropdown=new Select(companyNameField);
        dropdown.selectByVisibleText(countryName);
    }




}
