package functions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import pages.RegisterPage;
import pages.RegisterSuccessPage;

public class NewToursCommonFunctions {
    WebDriver driver;

    public NewToursCommonFunctions(WebDriver driver){
        this.driver = driver;
    }

    public String registerUser(String fName, String lName, int phone, String email, String address, String city, String state, int postalCode,String uName, String pass, String confirmPass){
        HomePage homePage = new HomePage(driver);
        homePage.selectRegisterMenu();

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.setFirstName(fName);
        registerPage.setLastName(lName);
        registerPage.setPhoneNum(phone);
        registerPage.setEmail(email);
        registerPage.setAddress(address);
        registerPage.setCity(city);
        registerPage.setState(state);
        registerPage.setPostalCode(postalCode);
        registerPage.selectCountry();
        registerPage.setUserName(uName);
        registerPage.setPassword(pass);
        registerPage.setConfirmPassword(confirmPass);
        registerPage.submit();

        RegisterSuccessPage registerSuccessPage = new RegisterSuccessPage(driver);
        String successText = registerSuccessPage.registerSuccessText();
        return successText;
    }
}
