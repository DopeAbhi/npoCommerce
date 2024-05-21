package PageObject;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCategoryPage extends AbstractComponent {

WebDriver driver;
    public ProductCategoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='sub-category-item']/h2/a")
    private List <WebElement> subCategory;




    public ProductDetailsPage selectSubCategory(String Category)
    {
        for (WebElement element : subCategory)
        {
            if (element.getText().equalsIgnoreCase(Category))
            {
                element.click();
            }
        }
        return new ProductDetailsPage(driver);
    }





}
