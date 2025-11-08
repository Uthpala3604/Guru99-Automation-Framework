package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(name = "userName")
    WebElement lUserName_ele;

    @FindBy(name = "password")
    WebElement lPassword_ele;

    @FindBy(xpath = "//input[@name='submit']")
    WebElement lSubmitBtn_ele;

    public void setlUserName(String lUserName){
        lUserName_ele.sendKeys(lUserName);
    }

    public void setlPassword(String lPassword){
        lPassword_ele.sendKeys(lPassword);
    }

    public void setlSubmitBtn(){
        lSubmitBtn_ele.click();
    }




}
