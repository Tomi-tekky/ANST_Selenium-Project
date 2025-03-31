package Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        ExtentManager.getInstance().createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getInstance().flush();
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Do nothing
    }

    @Override
    public void onStart(ITestContext context) {
        // Do nothing
    }

    @Override
    public void onFinish(ITestContext context) {
        // Do nothing
    }
}
