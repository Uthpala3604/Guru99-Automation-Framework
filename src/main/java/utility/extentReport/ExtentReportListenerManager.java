package utility.extentReport;

import base.BaseClass;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListenerManager extends BaseClass implements ITestListener {


    public void onTestStart(ITestResult result){
        String testName = result.getTestClass().getName() + " - " + result.getMethod().getMethodName();
        ExtentReportUtility.createTest(testName);
        ExtentReportUtility.test.info("Started Test Execution: "+result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result){
        ExtentReportUtility.test.pass("Test case passed: "+result.getName());
    }

    public void onTestFailure(ITestResult result){
        ExtentReportUtility.test.fail(result.getName()+" - Test case failed");
        ExtentReportUtility.test.fail(result.getThrowable());
        ExtentReportUtility.captureScreenShotAtBase64_ReportOnly_FailCase(driver, result.getName()+"_failed_point_screenshot");
    }

    public void onTestSkipped(ITestResult result){
        ExtentReportUtility.test.skip(result.getName()+" - Test case skipped");
        ExtentReportUtility.captureScreenShotAtBase64_ReportOnly_SkipCase(driver, result.getName()+"_skipped_point_screenshot");
    }
}
