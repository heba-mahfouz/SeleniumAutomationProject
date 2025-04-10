package Testing.Tests;

import Pages.CartPage;
import Pages.ProductCatalogue;
import Testing.TestComponent.BaseTest;
import Testing.TestComponent.Retry;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ErrorValidationsTest extends BaseTest {

     @Test(groups = {"ErrorHandling"},retryAnalyzer= Retry.class)
    public void loginErrorValidation ()

    {
   // String productName = "Build your own cheap computer";
    landingPage.LoginApplication("mahfouz123@gmail.com", "123456");
    Assert.assertEquals((landingPage.getErrorMassage()), ("Login was unsuccessful. Please correct the errors and try again."));
}
@Test
    public void productErrorValidation() throws InterruptedException{
    String productName = "Build your own cheap computer";
    ProductCatalogue productCatalogue = landingPage.LoginApplication("mahfouz123@gmail.com", "1234567");
    productCatalogue.selecComputers();
    productCatalogue.selecDeskTops();
    List<WebElement> products = productCatalogue.getProducList();
    productCatalogue.addProductToCart(productName);
    CartPage cartPage=productCatalogue.AddToCart();
    cartPage.setShopingCart();
    boolean match = cartPage.verifyProductDisply("Build your own cheap ");
    Assert.assertFalse(match);
}
}