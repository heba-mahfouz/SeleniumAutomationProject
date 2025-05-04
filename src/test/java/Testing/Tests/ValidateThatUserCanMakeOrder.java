package Testing.Tests;

import Pages.CartPage;
import Pages.CheckOutPage;
import Pages.OrderPage;
import Pages.ProductCatalogue;
import Testing.Data.DataReader;
import Testing.TestComponent.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ValidateThatUserCanMakeOrder extends BaseTest {
    String pName = "Order Number: 1933316";

    @Test(dataProvider = ("getData"), groups = {"Purchase"})
    public void submitOrder(HashMap<String, String> input) throws InterruptedException {

        ProductCatalogue productCatalogue = loginPage.LoginApplication(input.get("email"), input.get("password"));
        productCatalogue.selecComputers();
        productCatalogue.selecDeskTops();
        List<WebElement> products = productCatalogue.getProducList();
        productCatalogue.addProductToCart(input.get("productName"));
        CartPage cartPage = productCatalogue.AddToCart();
        cartPage.setShopingCart();
        boolean match = cartPage.verifyProductDisply(input.get("productName"));
        Assert.assertTrue(match);
        cartPage.dropDownList();
        cartPage.agreeCheckbox();
        CheckOutPage checkOut = cartPage.goTOCheckOut();
        checkOut.dropDownListaddress();
        checkOut.billing();
        checkOut.selectStoreCheckbox();
        checkOut.shipping();
        checkOut.selectPaymentCheckbox();
        checkOut.clickConfirmbtns();
        String confirmMass = checkOut.getmassageDisply();
        Assert.assertTrue(confirmMass.equalsIgnoreCase("Your order has been successfully processed!"));
        checkOut.finalConfirm();
    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() {

        ProductCatalogue productCatalogue = loginPage.LoginApplication("mahfouz123@gmail.com", "1234567");
        OrderPage orderPage = productCatalogue.goOrderPage();
        orderPage.setOrderbtn();
        boolean result = orderPage.verifyOrderDisply(pName);
        System.out.println("Verification result: " + result);
        Assert.assertTrue(result);
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
    }


    @DataProvider
    public Object[][] getData() throws IOException {
        DataReader dataReader = new DataReader();
        List<HashMap<String, String>> data;
        data = dataReader.getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//Testing//Data//purchaseOrder.json");
        return new Object[][]{{data.getFirst()}};
    }

}