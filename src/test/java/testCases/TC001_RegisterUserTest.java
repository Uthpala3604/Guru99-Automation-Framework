package testCases;

import base.BaseClass;
import functions.NewToursCommonFunctions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;
import utility.PropertyFileReader;
import utility.extentReport.ExtentReportListenerManager;

import java.time.Duration;

//@Listeners(ExtentReportListenerManager.class)
public class TC001_RegisterUserTest extends BaseClass {

    PropertyFileReader propertyFileReader = new PropertyFileReader();
    String pass = propertyFileReader.getProperty("testData", "pass");

    @Test
    public void TC001(){
        NewToursCommonFunctions newToursCommonFunctions = new NewToursCommonFunctions(driver);
        String actualText = newToursCommonFunctions.registerUser("Uthpala", "Pathirana", 071234567,
                "test2gmail.com", "No 112, Albania.", "Albania", "Albania",
                4509, "Uthpala123", "test123", "test123");
        Assert.assertTrue(actualText.contains("Dear"), "Registration Attempt Failed");

    }




}
