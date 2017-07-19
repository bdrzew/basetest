package config;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import test.common.SeleniumTest;

import java.io.File;
import java.io.IOException;

/**
 * Test listener responsible for handling logging and errors
 */
public class TestListener extends TestListenerAdapter {
    private final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void beforeConfiguration(ITestResult result) {
        super.beforeConfiguration(result);
        String appenderName = getClassMethodDescriptor(result);
        MDC.put("appendername", appenderName);
        MDC.put("ThreadId", String.valueOf(Thread.currentThread().getId()));

    }

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        String appenderName = getClassMethodDescriptor(result);
        MDC.put("appendername", appenderName);
        MDC.put("ThreadId", String.valueOf(Thread.currentThread().getId()));
    }

    @Override
    public void onConfigurationFailure(ITestResult iTestResult){
        super.onConfigurationFailure(iTestResult);
        addScreenshotToLog(iTestResult);
        logger.info("add log to report: configuration failure");
        addLogToReport(iTestResult);
    }

    @Override
    public void onConfigurationSuccess(ITestResult iTestResult) {
        super.onConfigurationSuccess(iTestResult);
        logger.info("add log to report: configuration success");
        addLogToReport(iTestResult);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
        logger.info("add log to report: tests success");
        addLogToReport(iTestResult);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
        logger.info("add log to report: tests skipped");
        addLogToReport(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        logger.error(ExceptionUtils.getStackTrace(iTestResult.getThrowable()));
        addScreenshotToLog(iTestResult);
        logger.info("add log to report: tests failure");
        addLogToReport(iTestResult);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        super.onTestFailedButWithinSuccessPercentage(iTestResult);
        addScreenshotToLog(iTestResult);
        logger.info("add log to report: tests failed but within success percentage");
        addLogToReport(iTestResult);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        logger.info("on Finish method invoked");
    }

    private void addScreenshotToLog(ITestResult iTestResult) {
        WebDriver driver = ((SeleniumTest)iTestResult.getInstance()).getDriver();
        File scrnsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location = getLogPath(iTestResult, ".jpg");
        try {
            FileUtils.copyFile(scrnsht, new File(location));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("<a href=\"" + location + "\">" +
            "<img src=\"" + location.replace("//", File.separator) +
            "\" width=\"192\" height=\"108\" /></a>");
    }

    private void addLogToReport(ITestResult iTestResult) {
        String location = getLogPath(iTestResult, ".log");
        Reporter.log("<p><a href=\"" + location + "\">" + getClassMethodDescriptor(iTestResult) +  "</a></p");
        MDC.remove("appendername");
    }

    private String getLogPath(ITestResult iTestResult, String fileExtension) {
        return new StringBuilder()
            .append(System.getProperty("user.dir")).append(File.separator)
            .append("target").append(File.separator)
            .append("surefire-reports").append(File.separator)
            .append("log").append(File.separator)
            .append(getClassMethodDescriptor(iTestResult))
            .append(fileExtension).toString();
    }

    private String getClassMethodDescriptor(ITestResult iTestResult) {
        return new StringBuilder()
            .append(iTestResult.getInstanceName()).append("_")
            .append(iTestResult.getName()).append("_")
            .append(String.valueOf(iTestResult.getParameters().hashCode()))
            .toString();
    }
}
