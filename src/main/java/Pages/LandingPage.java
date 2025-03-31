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

public class LandingPage {
    private final Actions actions;
    protected WebDriverWait wait;
    private WebDriver driver;
    private static final Logger logger  = LogManager.getLogger(LandingPage.class);


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver); // Initialize Actions object
    }

    @FindBy(xpath = "//a[normalize-space()='Shop by Category']")
    public static WebElement ShopByCategory;

    @FindBy(xpath = "//span[@class='title'][contains(text(), 'MP3 Players')]")
    public static WebElement SelectMP3Player;


    //Methods for different actions
    public void clickShopByCategory(WebElement ShopByCategory) throws InterruptedException {
        ShopByCategory.click();
    }
    public void clickOnMP3Player(WebElement SelectMP3Player) throws InterruptedException {
        SelectMP3Player.click();
    }
    public void clickOnMP3player() {
        waitForElementToBeClickable(SelectMP3Player).click();
    }
    public void ClickShopByCategory() {
        waitForElementToBeClickable(ShopByCategory).click();
    }
    // Explicit wait method
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
