package testCases;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;
import utility.PropertyFileReader;

public class TC001_RegisterUserTest extends BaseClass {

    PropertyFileReader propertyFileReader = new PropertyFileReader();
    String pass = propertyFileReader.getProperty("testData", "pass");

    @Test (groups = "smoke")
    public void TC001(){
        registerUser(); //call registerUser method
        verifyRegistrationSuccess(); //call verifyRegistrationSuccess method
    }
    public void registerUser(){
        HomePage homePage = new HomePage(driver);
        homePage.selectRegisterMenu();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstName("Uthpala");
        registerPage.setLastName("Pathirana");
        registerPage.setPhoneNum(071234567);
        registerPage.setEmail("test@gmail.com");
        registerPage.setAddress("No 112, Albania.");
        registerPage.setCity("Albania");
        registerPage.setState("Albania");
        registerPage.setPostalCode(4509);
        registerPage.selectCountry();
        registerPage.setUserName("Uthpala123");
        registerPage.setPassword(pass);
        registerPage.setConfirmPassword(pass);
        registerPage.submit();
    }

    public void verifyRegistrationSuccess(){
        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
        String actualText = registerSuccessPage.registerSuccessText();
        Assert.assertTrue(actualText.contains("Dear"), "Registration Attempt Failed");
        registerSuccessPage.clickLoginBtn();

    }
}
