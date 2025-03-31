import BasePackage.BaseTest;
import Pages.LandingPage;
import Pages.MP3_player;
import Pages.RegisterPage;
import Utils.ConfigReader;
import Utils.RandomDataGenerator;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Properties;
import static Pages.LandingPage.*;
import static Pages.RegisterPage.*;
import static Utils.DriverFactory.getDriver;

public class eCommerceTest extends BaseTest {
    Properties testConfigs = ConfigReader.loadProperties(System.getProperty("user.dir") +"/src/test/resources/config.properties");

    private LandingPage landingPage;
    private MP3_player mp3Player;
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUpTest() {

        test = extent.createTest("ClickShopByCategory");
    }

        @Test
        public void VerifyUserCanClickOnShopByCategory() throws InterruptedException {
            landingPage = new LandingPage(getDriver());

            // Test Data
            String url = testConfigs.getProperty("url");
            getDriver().get(url);

            //Action to click on Shop Category
            landingPage.waitForElementToBeClickable(ShopByCategory);
            landingPage.ClickShopByCategory();
            Assert.assertTrue(LandingPage.ShopByCategory.isDisplayed());
            test.log(Status.INFO, "Clicked on Shop By Category");
            test.log(Status.PASS, "Test completed successfully.");
        }


    @Test
        public void VerifyUserCanSelectMP3Player() throws InterruptedException {
        landingPage = new LandingPage(getDriver());
        // Test Data
        String url = testConfigs.getProperty("url");
        getDriver().get(url);

        //Action to select MP3 player
        landingPage.waitForElementToBeClickable(ShopByCategory);
        landingPage.ClickShopByCategory();
        landingPage.waitForElementToBeClickable(SelectMP3Player);
        Assert.assertTrue(SelectMP3Player.isDisplayed());
        landingPage.clickOnMP3player();
        test.log(Status.INFO, "Clicked on MP3 Player");
        test.log(Status.PASS, "Test completed successfully.");
    }

    @Test
        public void VerifyUserCanHoverOnProduct() throws InterruptedException {
        landingPage = new LandingPage(getDriver());
        mp3Player = new MP3_player(getDriver());
        // Test Data
        String url = testConfigs.getProperty("url");
        getDriver().get(url);

        //Action to hover over menu
        landingPage.waitForElementToBeClickable(ShopByCategory);
        landingPage.ClickShopByCategory();
        landingPage.waitForElementToBeClickable(SelectMP3Player);
        Assert.assertTrue(SelectMP3Player.isDisplayed());
        landingPage.clickOnMP3player();
        mp3Player.scroll(getDriver());
        mp3Player.hoverOverMenu();
        mp3Player.hoverAndClickSubmenu();
        test.log(Status.INFO, "Hover over element and added wishlist");
        test.log(Status.PASS, "Test completed successfully.");
    }

    @Test
    public void VerifyUserCanRegister() throws InterruptedException {
        landingPage = new LandingPage(getDriver());
        mp3Player = new MP3_player(getDriver());
        registerPage = new RegisterPage(getDriver());

        // Test Data
        String url = testConfigs.getProperty("url");
        getDriver().get(url);

        // Generate random test data
        String randomFirstname = RandomDataGenerator.getRandomString("John", 1000);
        String randomLastname = RandomDataGenerator.getRandomString("Doe", 1000);
        String randomEmail = RandomDataGenerator.getRandomEmail("example.com");
        String randomPhone = RandomDataGenerator.getRandomPhoneNumber();
        String Password = RandomDataGenerator.getRandomString("password", 10000);

        //Action to hover over menu
        landingPage.waitForElementToBeClickable(ShopByCategory);
        landingPage.ClickShopByCategory();
        landingPage.waitForElementToBeClickable(SelectMP3Player);
        Assert.assertTrue(SelectMP3Player.isDisplayed());
        landingPage.clickOnMP3Player(SelectMP3Player);
        mp3Player.scroll(getDriver());
        mp3Player.hoverOverMenu();
        mp3Player.hoverAndClickSubmenu();
        mp3Player.clickRegister();


        //Fill form details
        registerPage.waitForElementToBeClickable(firstname);
        Assert.assertTrue(firstname.isDisplayed());
        registerPage.inputFirstname(randomFirstname);

        registerPage.waitForElementToBeClickable(lastname);
        Assert.assertTrue(lastname.isDisplayed());
        registerPage.inputLastname(randomLastname);

        registerPage.waitForElementToBeClickable(email);
        Assert.assertTrue(email.isDisplayed());
        registerPage.inputEmail(randomEmail);

        registerPage.waitForElementToBeClickable(telephone);
        Assert.assertTrue(telephone.isDisplayed());
        registerPage.inputTelephone(randomPhone);

        registerPage.waitForElementToBeClickable(password);
        Assert.assertTrue(password.isDisplayed());
        registerPage.inputPassword(Password);

        registerPage.waitForElementToBeClickable(ConfirmPassword);
        Assert.assertTrue(ConfirmPassword.isDisplayed());
        registerPage.ConfirmPassword(Password);

        registerPage.clickAgree();
        registerPage.clickContinue();

        Assert.assertTrue(Continue2.isDisplayed());
        registerPage.clickContinue2();
        test.log(Status.INFO, "Clicked on Register");
        test.log(Status.PASS, "Test completed successfully.");
    }
}
