package BasePackage;


import Utils.DriverFactory;
import Utils.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import static Utils.DriverFactory.getDriver;

public class BaseTest {
    public static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    public static ExtentReports extent;
    protected ExtentTest test;
    protected Properties config;


    @BeforeSuite
    public void beforeSuite() {

        extent = ExtentManager.getInstance();
    }

    @BeforeMethod
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {

        DriverFactory.setDriver(browser);
        driver = getDriver();
        driver.manage().window().maximize();

        // Load configuration properties
        config = new Properties();

        //Initialize Explicit Wait
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        // Set timeouts
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        DriverFactory.quitDriver();

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Case Failed: " + result.getName());
            test.log(Status.FAIL, "Reason: " + result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Case Passed: " + result.getName());
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test Case Skipped: " + result.getName());
        }

        logger.info("Tearing down the test environment.");
        logger.info("Test environment teardown completed.");
    }
    @AfterSuite
    public void afterSuite () {
        extent.flush();
    }
}

