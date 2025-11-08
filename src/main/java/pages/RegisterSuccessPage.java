package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterSuccessPage {

    WebDriver driver;

    public RegisterSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'Dear')]")
    WebElement successText_ele;

    public String registerSuccessText(){
        String registerSuccessText = successText_ele.getText();
        return registerSuccessText;
    }


    @FindBy(xpath = "//a[normalize-space()='sign-in']")
    WebElement loginBtn_ele;

    public void clickLoginBtn(){
        loginBtn_ele.click();
    }


}
