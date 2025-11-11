package utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int failedCount = 0;
    int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (failedCount<maxRetryCount){
            failedCount++;
            return true;  //retry the test
        }
        return false;
    }
}
