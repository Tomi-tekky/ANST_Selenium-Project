package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard {
    protected WebDriverWait wait;
    private WebDriver driver;
    private static final Logger logger  = LogManager.getLogger(Dashboard.class);//log function for recording test execution


    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//h1[normalize-space()='Quickly Dashboard']")
    public static WebElement Quickly;//creating webElement of the Quickly label on the dashboard

    @FindBy(id = "logoutBtn")
    public static WebElement logout;//creating webElement of the Logout button on the dashboard


    //Methods for different actions

    // Explicit wait method
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
