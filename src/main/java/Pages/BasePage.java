package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div/div/ul/li[@id='topcartlink']/a")
    WebElement shopingCart;
    @FindBy(css = "div[class='header-links'] a[class='account']")
    WebElement accountbtn;


    public void waitForElementToAppear(By FindBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
    }

    public void waitForElementToDisAppearTh(By FindBy) throws InterruptedException {
        Thread.sleep(1000);
    }

    public void waitForElementToDisAppear(By FindBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(FindBy));
    }

    public CartPage setShopingCart() {
        shopingCart.click();
        CartPage cartPage = new CartPage(driver);
        return cartPage;
    }

    public OrderPage goOrderPage() {
        accountbtn.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }


}

