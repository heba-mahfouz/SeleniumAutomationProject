package Testing.TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


public class Retry implements IRetryAnalyzer {
    int count = 0;
    int maxtry = 1;

    public boolean retry(ITestResult var1) {
        if (count < maxtry) {
            count++;
            return true;
        }
        return false;
    }


}


