package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class CartPage extends BasePage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//td/a[@href='/build-your-cheap-own-computer']")
    private List<WebElement> cartProduct;
    @FindBy(xpath = "//button[@class='button-1 checkout-button']")
    WebElement checkOut;

    public Boolean verifyProductDisply(String productName) {
        boolean match = cartProduct.stream().
                anyMatch(product -> product.getText().equalsIgnoreCase(productName));

        return match;
    }

    public void dropDownList() {

        WebElement staticDropDown = driver.findElement(By.cssSelector("#CountryId"));
        Select dropDown = new Select(staticDropDown);
        dropDown.selectByVisibleText("Andorra");
    }

    public void agreeCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("#termsofservice"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public CheckOutPage goTOCheckOut() throws InterruptedException {
        checkOut.click();
        CheckOutPage checkOut = new CheckOutPage(driver);
        return checkOut;
    }

}
