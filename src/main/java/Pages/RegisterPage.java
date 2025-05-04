package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By register = By.linkText("Register");
    By female = By.id("gender-female");
    By FName = By.id("FirstName");
    By LName = By.id("LastName");
    By email = By.id("Email");
    By password = By.id("Password");
    By confirmPassword = By.id("ConfirmPassword");
    By registerBtn = By.id("register-button");
    @FindBy(className = "result")
    WebElement Message;
    public void setRegister(String FirstName, String LastName, String Email, String Password, String ConfirmPassword) {
        driver.findElement(register).click();
        driver.findElement(female).click();
        driver.findElement(FName).sendKeys(FirstName);
        driver.findElement(LName).sendKeys(LastName);
        driver.findElement(email).sendKeys(Email);
        driver.findElement(password).sendKeys(Password);
        driver.findElement(confirmPassword).sendKeys(ConfirmPassword);
        driver.findElement(registerBtn).click();
    }

    public String getSucceededMassage() {
        return Message.getText().trim();

    }
}
