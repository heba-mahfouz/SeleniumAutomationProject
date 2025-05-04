package Testing.Tests;

import Pages.RegisterPage;
import Testing.TestComponent.BaseTest;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ValidDataToRegister extends BaseTest {
    @Test
    public void TestValidData() {
        Faker faker = new Faker();
        SoftAssert soft = new SoftAssert();
        String firstName = faker.name().firstName();
        String LastName = faker.name().lastName();
        String Email = faker.internet().emailAddress();
        String Password = Faker.instance().number().toString();
        RegisterPage register = new RegisterPage(driver);
        register.setRegister(firstName, LastName, Email, Password, Password);
        String match = register.getSucceededMassage();
        soft.assertEquals(match, "Your registration completed");
        soft.assertAll();
    }


}
