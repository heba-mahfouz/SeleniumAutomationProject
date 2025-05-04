package Testing.Tests;

import Testing.TestComponent.BaseTest;
import Testing.TestComponent.Retry;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InvalidLogin extends BaseTest {

    @Test(groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void loginErrorValidation() {
        loginPage.LoginApplication("mahfouz123@gmail.com", "123456");
        Assert.assertEquals((loginPage.getErrorMassage()), ("Login was unsuccessful. Please correct the errors and try again."));
    }

}