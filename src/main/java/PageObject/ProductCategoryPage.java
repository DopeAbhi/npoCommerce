package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductCategoryPage extends AbstractComponent {

WebDriver driver;

    public ProductCategoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='sub-category-item']/h2/a")
     List <WebElement> subCategory;




    public ProductDetailsPage selectSubCategory(String Category)
    {
        for (WebElement element : subCategory)
        {

            if (element.getText().equalsIgnoreCase(Category))
            {
                explicitWait.until(ExpectedConditions.elementToBeClickable(element)).click();
                break;

            }
        }
        return new ProductDetailsPage(driver);
    }





}
