package utility.extentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentReportUtility {

    public static ExtentSparkReporter sparkReporter;

    public static ExtentReports extent;
    public static ExtentTest test;

    public static void startReporter(){
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//test-output//extentReports//ExtentReport.html");
        sparkReporter.config().setDocumentTitle("Automation Test Report for Guru99 Demo Site");
        sparkReporter.config().setReportName("Test Report for Guru99 Demo Site");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("ProjectName", "FE_Automation_Guru99DemoSite");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Operating Systems", System.getProperty("os.name"));
        extent.setSystemInfo("java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Tester", System.getProperty("user.name"));
    }

    public static void createTest(String testName){
        test = extent.createTest(testName);
    }

    public static void endReport(){
        extent.flush();
    }

    //Add screenshots to the extent report

    //using base64 -- we can directly append the ss to the extent report
    public static void captureScreenShotAtBase64_ReportOnly_StepInfo(WebDriver driver, String message){
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        test.info(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
    }

    public static void captureScreenShotAtBase64_ReportOnly_FailCase(WebDriver driver, String message){
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        test.fail(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
    }

    public static void captureScreenShotAtBase64_ReportOnly_SkipCase(WebDriver driver, String message){
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        test.skip(message, MediaEntityBuilder.createScreenCaptureFromBase64String(base64).build());
    }
}
