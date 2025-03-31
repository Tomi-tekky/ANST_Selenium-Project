package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MP3_player {
    private final Actions actions;
    protected WebDriverWait wait;
    private WebDriver driver;
    private static final Logger logger  = LogManager.getLogger(MP3_player.class);

    public MP3_player(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver); // Initialize Actions object
    }


    @FindBy(xpath = "//img[contains(@title, 'HTC Touch HD')][1]")
    public static WebElement product;
    @FindBy(xpath = "//i[@class='fas fa-heart'][1]")
    public static WebElement wishList;
    @FindBy(xpath = "//a[@class='btn btn-secondary btn-block']")
    public static WebElement Register;


    public void scroll(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
    }
    public void hoverOverMenu() {
        actions.moveToElement(product).perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void hoverAndClickSubmenu() {
        hoverOverMenu(); // Call hover method
        wishList.click(); // Click on the wishList icon
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void clickRegister() {
        Register.click();
    }
    // Explicit wait method
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
