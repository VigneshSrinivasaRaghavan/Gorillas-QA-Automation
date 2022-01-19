package listeners;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import driver.DriverManager;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reports.ExtentReport;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

/*
 * Listener class hooks with TestNG and listens to all test status
 * When test is passed it will take screenshot and attach to Report
 * When test is passed or failed it will log in the report
 * Once all test is finished it will flush the report
 */

public class TestListener implements ITestListener {

    public void onTestFailure(ITestResult result) {
        if(result.getThrowable()!=null){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
        }
        File file = DriverManager.getDriver().getScreenshotAs(OutputType.FILE);
        byte[] encoded = null;
        try {
            encoded = Base64.encodeBase64(FileUtils.readFileToByteArray(file));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        ExtentReport.getTest().fail("Test Failed",
                MediaEntityBuilder.createScreenCaptureFromBase64String(new String(encoded, StandardCharsets.US_ASCII)).build());

        ExtentReport.getTest().fail(result.getThrowable());
    }

    public void onTestStart(ITestResult result) {
        ExtentReport.startTest(result.getName(),result.getMethod().getDescription());
    }

    public void onTestSuccess(ITestResult result) {
        ExtentReport.getTest().log(Status.PASS,"Test Passed");
    }

    public void onTestSkipped(ITestResult result) {
        ExtentReport.getTest().log(Status.SKIP,"Test Skipped");
    }

    public void onFinish(ITestContext context) {
        ExtentReport.getReporter().flush();
    }
}