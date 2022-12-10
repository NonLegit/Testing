
package mobile.testComponents;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.ExtentReporterGen;
import web.testComponents.BaseTest;

import java.io.IOException;
import java.util.Arrays;

import static web.constants.TestConstants.REPORT_PATH;

/**
 * this class is for TestNG which is used to listen on the
 * testcases, as if one of the tests failed then we can preform simple action like take screenshot
 */
public class Listeners extends BaseTest implements ITestListener {

    /**
     * extent report variable which is used to make reports of tests which succeeded and that which failed
     */
    ExtentReports reports = ExtentReporterGen.getReporterObject(REPORT_PATH);

    /**
     * this is a variable that defines a single test
     */
    ExtentTest test;

    /**
     * This is a thread safety purpose variable, you can refer to https://www.baeldung.com/java-threadlocal as a small tutoral
     * this is just stores a copy of the test report just in case of parallel test not to overlap in reporting the result
     */
    ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    /**
     * this is a listener which is called whenever the test starts, here we are initializing the extent reports and protect it using ThreadLocal
     * @param result: this is a variable that contains information about the test when started
     */
    @Override
    public void onTestStart(ITestResult result) {
        test = reports.createTest(result.getMethod().getMethodName());
        extentTestThreadLocal.set(test);
    }

    /**
     * this is a listener which is called whenever the test success, here we are getting the test from out threadLocal and success it
     * @param result: this is a variable that contains information about the test when succeeded
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        extentTestThreadLocal.get().pass(result.getMethod().getDescription() +" with parameter = " + Arrays.toString(result.getParameters()) + " passed successfully");
    }

    /**
     * this is a listener which is called whenever the test fails, here we are getting the test from out threadLocal and fail it, adds screenshot to the report of failed case
     * @param result: this is a variable that contains information about the test when failed
     */
    @Override
    public void onTestFailure(ITestResult result) {
        extentTestThreadLocal.get().fail(result.getThrowable());
        extentTestThreadLocal.get().fail(result.getMethod().getDescription() +" with parameter = " + Arrays.toString(Arrays.stream(result.getMethod().getAttributes()).toArray()) + " failed");
        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            String filepath = getScreenShot(result.getMethod().getMethodName(), driver);
            extentTestThreadLocal.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
        } catch (IOException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Not used by my application
     * @param result: the result data
     */
    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    /**
     * Not used by my application
     * @param result: the result data
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    /**
     * Not used by my application
     * @param result: the result data
     */
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    /**
     * Not used by my application
     * @param context: the test context
     */
    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    /**
     * Not used by my application
     * @param context: the test context
     */
    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }

}