package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v136.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSuccessPage {
    WebDriver driver;

    public LoginSuccessPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(), 'Thank')]")
    WebElement successLoginText_ele;


    public String loginSuccessText(){
        String loginSuccessText = successLoginText_ele.getText();
        return loginSuccessText;
    }

}
