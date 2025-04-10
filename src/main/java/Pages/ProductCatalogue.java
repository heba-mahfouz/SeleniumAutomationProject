package PageOpjects;

import Abstract.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;

    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='listbox']/ul/li[@class='inactive']/a[@href='/computers']")
    WebElement Computers;
    @FindBy(css = "li[class='active'] li:nth-child(1) a:nth-child(1)")
    WebElement Desktops;
    @FindBy(xpath = "//div[@class='product-grid']/div[@class='item-box']/div[@class='product-item']/div[@class='details']/h2[@class='product-title']")
    List<WebElement> products;
    By productBy = By.xpath("//div[@class='product-grid']/div[@class='item-box']/div[@class='product-item']/div[@class='details']/h2[@class='product-title']");
    By addToCart = By.xpath("//div[@class='details']/div[@class='add-info']/div[@class='buttons']/input[@class='button-2 product-box-add-to-cart-button']");
    By addToCart2 = By.xpath("//div/input[@class='button-1 add-to-cart-button']");
    By animation= By.cssSelector(".bar-notification success");
    By massage=By.cssSelector(".content");
    public void selecComputers() throws InterruptedException {
        Computers.click();

    }
    public void selecDeskTops() {

        Desktops.click();
        waitForElementToAppear(addToCart);
    }

    public List<WebElement> getProducList() {
        //waitForElementToAppear(productBy);
        return products;
    }
    public WebElement getProductByName(String productName){
        WebElement prod = getProducList().stream().
                filter(product->product.
                        findElement(By.xpath("//div[@class='product-grid']/div[@class='item-box']/div[@class='product-item']/div[@class='details']/h2[@class='product-title']")).getText().
                        equals(productName)).findFirst().orElse(null);
        return prod;
    }

    public WebElement addProductToCart(String productName) throws InterruptedException {
        waitForElementToAppear(addToCart);
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToDisAppearTh(animation);

      return prod;
    }

    public CartPage AddToCart() throws InterruptedException {
        CartPage cartPage=new CartPage(driver);
        driver.findElement(addToCart2).click();
        waitForElementToDisAppearTh(animation);
        waitForElementToDisAppear(massage);
        return cartPage;
    }


}