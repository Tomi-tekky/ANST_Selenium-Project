package Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    protected WebDriverWait wait;
    private WebDriver driver;
    private static final Logger logger  = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    private final By emailAddressField = By.id("email");
    private final By PasswordField = By.id("password");
    private final By LoginButton = By.xpath("//button[@type='submit']");
    private final By errorMessage = By.id("loginMsg");


    //Methods for different actions
    public void ClickSignIn() {
    WebElement UserSignIn = wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButton));
    UserSignIn.click();
    }


  //Explicit wait method
    public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void EnterEmail(String emailAddress) {
       WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressField));
       emailField.sendKeys(emailAddress);
    }
    public void EnterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordField));
        passwordField.sendKeys(password);
    }
    public void setErrorMessage() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    }
}
