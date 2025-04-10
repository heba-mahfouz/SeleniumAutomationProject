package PageOpjects;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LandingPage extends AbstractComponent {
    WebDriver driver;

    public LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (linkText = "Log in")
    WebElement Loginbtn;

    @FindBy (id = "Email")
     WebElement UserEmail;

    @FindBy(id = "Password")
    WebElement UserPassword;

    @FindBy(css = ".button-1.login-button")
    WebElement Submit;
    @FindBy(css = "div[class='validation-summary-errors'] span")
    WebElement errorMassage;

    public ProductCatalogue LoginApplication(String email, String password) {
        Loginbtn.click();
        UserEmail.sendKeys(email);
        UserPassword.sendKeys(password);
        Submit.click();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        return productCatalogue;
    }
    public String getErrorMassage(){
        waitForElementToAppear(By.cssSelector("div[class='validation-summary-errors'] span"));
        return errorMassage.getText().trim();

    }
    public void GoTo (){

        driver.get("https://demowebshop.tricentis.com/build-your-cheap-own-computer");
    }

}