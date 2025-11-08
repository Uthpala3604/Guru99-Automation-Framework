package testCases;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utility.PropertyFileReader;

import java.time.Duration;

public class TC002_RegisterLoginUserTest extends BaseClass {

    PropertyFileReader propertyFileReader = new PropertyFileReader();
    String pass = propertyFileReader.getProperty("testData", "pass");

    @Test
    public void TC002() {
        registerUser();
        verifyRegistrationSuccess();
        loginUser();
        verifyLoginSuccess();
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

    public void loginUser(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.setlUserName("Uthpala123");
        loginPage.setlPassword(pass);
        loginPage.setlSubmitBtn();
    }

    public void verifyLoginSuccess(){
        LoginSuccessPage loginSuccessPage = new LoginSuccessPage(driver);
        String actualLoginText = loginSuccessPage.loginSuccessText();
        Assert.assertTrue(actualLoginText.contains("Thank"), "Login Attempt Failed ");
    }


}
