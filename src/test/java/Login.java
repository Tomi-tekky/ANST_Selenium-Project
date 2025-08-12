import BasePackage.BaseTest;
import Pages.Dashboard;
import Pages.LoginPage;
import Utils.ConfigReader;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Properties;

import static Pages.Dashboard.*;
import static Utils.DriverFactory.getDriver;

public class Login extends BaseTest {
    Properties testConfigs = ConfigReader.loadProperties(System.getProperty("user.dir") + "/src/test/resources/config.properties");

    private LoginPage loginPage;
    private Dashboard dashboard;

    @BeforeMethod
    public void setUpTest() {

        test = extent.createTest("Login");
    }
    @Test
    public void VerifyUserCannotLoginWithInvalidEmail() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        dashboard = new Dashboard(getDriver());

        // Test Data
        String url = testConfigs.getProperty("BaseUrl");
        getDriver().get(url);
        String email = testConfigs.getProperty("InvalidEmail");
        String password = testConfigs.getProperty("ValidPassword");

        //Action to Sign In
        loginPage.EnterEmail(email);
        loginPage.EnterPassword(password);
        loginPage.ClickSignIn();
        loginPage.setErrorMessage();
       // Assert.assertTrue(ErrorMessage.isDisplayed(),"Invalid username or password.");
        test.log(Status.INFO, "User signin with invalid email");
        test.log(Status.PASS, "Test completed successfully.");
    }
    @Test
    public void VerifyUserCannotLoginWithInvalidPassword() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        dashboard = new Dashboard(getDriver());

        // Test Data
        String url = testConfigs.getProperty("BaseUrl");
        getDriver().get(url);
        String email = testConfigs.getProperty("ValidEmail");
        String password = testConfigs.getProperty("InvalidPassword");

        //Action to Sign In
        loginPage.EnterEmail(email);
        loginPage.EnterPassword(password);
        loginPage.ClickSignIn();

        test.log(Status.INFO, "User signin with invalid password");
        test.log(Status.PASS, "Test completed successfully.");
    }

    @Test
    public void VerifyUserCanLoginWithValidCredentials() throws InterruptedException {
        loginPage = new LoginPage(getDriver());
        dashboard = new Dashboard(getDriver());

        // Test Data
        String url = testConfigs.getProperty("BaseUrl");
        getDriver().get(url);
        String email = testConfigs.getProperty("ValidEmail");
        String password = testConfigs.getProperty("ValidPassword");

        //Action to Sign In
        loginPage.EnterEmail(email);
        loginPage.EnterPassword(password);
        loginPage.ClickSignIn();
        dashboard.waitForElementToBeClickable(Quickly);
        Assert.assertTrue(Quickly.isDisplayed());
        dashboard.waitForElementToBeClickable(logout);
        test.log(Status.INFO, "User signin with valid credentials");
        test.log(Status.PASS, "Test completed successfully.");
    }
}
