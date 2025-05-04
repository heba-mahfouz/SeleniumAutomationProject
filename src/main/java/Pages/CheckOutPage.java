package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {
    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@class='page checkout-page']//ol[@class='opc']/li[@class='tab-section allow active']/div[@class='step a-item']/div[@class='buttons']/input[@class='button-1 new-address-next-step-button']")
    WebElement billingbtn;
    @FindBy(css = "input[onclick='Shipping.save()']")
    WebElement shippingbtn;
    @FindBy(css = "li[id=\"opc-shipping_method\"] h2")
    WebElement shippinMethod;
    @FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
    WebElement shippbtn;
    @FindBy(css = "input[class='button-1 payment-method-next-step-button']")
    WebElement paymentbtn;
    @FindBy(css = "input[class='button-1 payment-info-next-step-button']")
    WebElement paymentInfobtn;
    @FindBy(css = "input[value='Confirm']")
    WebElement confirmbtn;
    @FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']")
    WebElement finalbtn;
    @FindBy(xpath = "//div[@class='title']")
    WebElement confirmMassage;

    public void dropDownListaddress() throws InterruptedException {
        Thread.sleep(1000);
        WebElement staticDropDown = driver.findElement(By.cssSelector("#billing-address-select"));
        Select dropDown = new Select(staticDropDown);
        dropDown.getFirstSelectedOption();
    }

    public void selectStoreCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("#PickUpInStore"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void billing() {
        billingbtn.click();
    }

    public void shipping() {
        shippingbtn.click();

    }

    public void selectPaymentCheckbox() {
        WebElement checkbox = driver.findElement(By.cssSelector("#paymentmethod_1"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    public void clickConfirmbtns() {
        paymentbtn.click();
        paymentInfobtn.click();
        confirmbtn.click();
    }

    public String getmassageDisply() {
        return confirmMassage.getText();
    }


    public void finalConfirm() {
        finalbtn.click();
    }
}