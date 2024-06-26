package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends AbstractComponent {

    WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
        super (driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    @FindBy(css = "#BillingNewAddress_FirstName")
    private WebElement firstNameField;

    @FindBy(css="#BillingNewAddress_LastName")
    private WebElement lastNameField;

    @FindBy(css="[name='BillingNewAddress.Email']")
    private WebElement emailField;

    @FindBy(css="[name='BillingNewAddress.Company']")
    private WebElement companyNameField;

    @FindBy(css="[data-trigger='country-select']")
    private WebElement countryDropDown;

    @FindBy(css="#BillingNewAddress_City")
    private WebElement cityField;

    @FindBy(css="[name='BillingNewAddress.Address1']")
    private WebElement firstAddressField;

    @FindBy(css="[name='BillingNewAddress.Address2']")
    private WebElement secondAddressField;

    @FindBy(css="[name='BillingNewAddress.ZipPostalCode']")
    private WebElement zipCodeField;

    @FindBy(css="[name='BillingNewAddress.PhoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(css="#BillingNewAddress_FaxNumber")
    private WebElement faxNumberField;

    @FindBy(xpath = "//button[text()='Continue']")
    private List<WebElement> continueButton;

    @FindBy(css="[id='paymentmethod_1']")
    private WebElement paymentmethod;

    @FindBy(css = "#shippingoption_1")
    private WebElement shippingOption;

    @FindBy(xpath = "//label[contains(text(),'Select a billing address')]")
    private List<WebElement> savedAddress;

    @FindBy(css=".dropdownlists")
    private WebElement typeofCard;

    @FindBy(id="CardholderName")
    private WebElement cardholderName;

    @FindBy(id="CardNumber")
    private WebElement cardNumber;

    @FindBy(id="ExpireMonth")
    private WebElement expireMonth;

    @FindBy(id="ExpireYear")
    private WebElement expireYear;

     @FindBy(id="CardCode")
    private WebElement cardCode;

     @FindBy(xpath = "//button[contains(text(),'Confirm')]")
     private WebElement confirmButton;



    public void  setFirstName(String firstName)
    {

        if (firstNameField.getAttribute("value") == null || firstNameField.getAttribute("value").isEmpty()) {
            firstNameField.sendKeys(firstName);
        }
    }
    public  void setLastName(String lastName)
    {
        if (lastNameField.getAttribute("value") == null || lastNameField.getAttribute("value").isEmpty()) {
            lastNameField.sendKeys(lastName);
        }
    }

    public void setEmail(String email)
    {
        if(emailField.getAttribute("value")==null ||emailField.getAttribute("value").isEmpty())
        {
            emailField.sendKeys(email);
        }
    }

    public void setCompanyName(String companyName) {
        if (companyNameField.getAttribute("value") == null || companyNameField.getAttribute("value").isEmpty()) {
            companyNameField.sendKeys(companyName);
        }
    }

    public void selectCountry(String countryName){

        selectMethod(countryDropDown, countryName);
    }

    public void setCityField(String cityName)
    {
        cityField.sendKeys(cityName);
    }

    public void setFirstAddress(String firstAddress)
    {
        firstAddressField.sendKeys(firstAddress);
    }

    public void setSecondAddress(String secondAddress)
    {
        secondAddressField.sendKeys(secondAddress);
    }

    public void setZipCode(String zipCode)
    {
        zipCodeField.sendKeys(zipCode);
    }

    public void setPhoneNumber(String phoneNumber)
    {
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void setFaxNumberField(String faxNumber)
    {
        faxNumberField.sendKeys(faxNumber);
    }

    public void continueButtonClick(int index)
    {
        continueButton.get(index).click();
    }


    public void selectPaymentMethod (String paymentMethod)
    {
        if (paymentMethod.equalsIgnoreCase("Credit Card"))
        {
            paymentmethod.click();
        }

    }

    public void selectShippingMethod ()
    {
        shippingOption.click();
    }

    public boolean savedAddressCheck()
    {
        return savedAddress.isEmpty();

    }

    public void setCreditCard(String card)
    {
        selectMethod(typeofCard,card);
    }


    public void setCardholderName(String Name)
    {
        cardholderName.sendKeys(Name);
    }

    public void setCardNumber(String Number)
    {

        cardNumber.sendKeys(Number);

    }

    public void setCardExpireMonth(String month)
    {
        selectMethod(expireMonth,month);
    }
    public void setCardExpireYear(String year)
    {
        selectMethod(expireYear,year);
    }
    public void setCardCode(String code)
    {
        cardCode.sendKeys(code);
    }

    public void confirmButtonClick()
    {
        confirmButton.click();
    }



}
