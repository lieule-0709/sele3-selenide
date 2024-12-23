package retry;

import enums.PropKey;
import io.cucumber.java.sl.In;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.PropertiesHelper;

public class Retry implements IRetryAnalyzer {
    int maxRetries = System.getProperty(PropKey.RETRY.getKey())!= null ?
            Integer.parseInt(System.getProperty(PropKey.RETRY.getKey())) :
            Integer.parseInt(PropertiesHelper.getProperty(PropKey.RETRY));
    int count = 0;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if(!iTestResult.isSuccess()) {
            if(count < maxRetries) {
                count++;
                return true;
            }
        }
        return false;
    }
}
