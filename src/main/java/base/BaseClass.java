package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utility.extentReport.ExtentReportUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Locale;
import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;

    public Properties prop;

    @BeforeSuite
    public void beforeSuite(){
        ExtentReportUtility.startReporter();
    }

    @BeforeMethod
    public void openPage() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+
                                                "\\src\\test\\resources\\config.properties");

        prop = new Properties();
        prop.load(fileInputStream);

        String env = prop.getProperty("env");
        String browser = prop.getProperty("browser");


        //Select browser
        switch(browser.toLowerCase()){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Browser not support: "+browser);
                return;
        }


        driver.manage().window().maximize();
        String iml_wait = prop.getProperty("implicit_wait");
        long imp_wait_long  = Long.parseLong(iml_wait); //to convert to the long data type
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(imp_wait_long));

        //Select environment
        String appUrl = prop.getProperty(env + ".url");
        if (appUrl == null){
            throw new IllegalArgumentException("URL not defined for environment: "+env);
        }
        driver.get(appUrl);

        //driver.get(prop.getProperty("App_url"));
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @AfterSuite
    public void afterSuite(){
        ExtentReportUtility.endReport();
    }
}
