package PageOpjects;

import Abstract.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {
    WebDriver driver;
    public String pName;

    public  OrderPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//div[@class='listbox']/ul[@class='list']/li/a[@href='/customer/orders']")
    WebElement orderbtn;
@FindBy (xpath = "//div[@class='center-2']/div[@class='page account-page order-list-page']/div[@class='page-body']/div[@class='order-list']/div[@class='section order-item']/div[@class='title']")
  private List<WebElement> productsNames;

    public boolean verifyOrderDisply(String pName) {
        this.pName = pName;
        boolean match = productsNames.stream()
                .anyMatch(product -> product.getText().equalsIgnoreCase(pName));


        return match;
    }
    public void setOrderbtn(){
        orderbtn.click();
    }






}
