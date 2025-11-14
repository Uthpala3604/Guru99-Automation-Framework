package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "firstName")
    WebElement firstName_ele;

    @FindBy(xpath = "//input[@name='lastName']")
    WebElement lastName_ele;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phone_ele;

    @FindBy(xpath = "//input[@name='address1']")
    WebElement address_ele;

    @FindBy(xpath = "//input[@name='city']")
    WebElement city_ele;

    @FindBy(name="state")
    WebElement state_ele;

    @FindBy(name = "postalCode")
    WebElement postalCode_ele;

    @FindBy(xpath = "//input[@id='userName']")
    WebElement email_ele;

    @FindBy(xpath = "//select[@name='country']")
    WebElement countrySelect_ele;

    @FindBy(xpath = "//input[@id='email']")
    WebElement userName_ele;

    @FindBy(name = "password")
    WebElement password_ele;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    WebElement confirmPassword_ele;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement submitBtn_ele;

    public void setFirstName(String firstName){

       firstName_ele.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        lastName_ele.sendKeys(lastName);
    }

    public void setPhoneNum(int phone){
        phone_ele.sendKeys(Integer.toString(phone));
    }

    public void setEmail(String email){
        email_ele.sendKeys(email);
    }

    public void setAddress(String address){
        address_ele.sendKeys(address);
    }

    public void setCity(String city){
        city_ele.sendKeys(city);
    }

    public void setState(String state){
        state_ele.sendKeys(state);
    }

    public void setPostalCode(int postalCode){
        postalCode_ele.sendKeys(Integer.toString(postalCode));
    }

    public void selectCountry(){
        WebElement countrySelectElement = countrySelect_ele; //find the element
        Select dropdownCountry = new Select(countrySelectElement);
        dropdownCountry.selectByIndex(2);
    }

    public void setUserName(String userName){
        userName_ele.sendKeys(userName);
    }

    public void setPassword(String password){
       password_ele.sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword){
        confirmPassword_ele.sendKeys(confirmPassword);
    }

    public void submit(){
        submitBtn_ele.click();
    }
}
