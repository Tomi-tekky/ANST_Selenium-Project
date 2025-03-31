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

public class RegisterPage {
    private final Actions actions;
    protected WebDriverWait wait;
    private WebDriver driver;
    private static final Logger logger  = LogManager.getLogger(RegisterPage.class);

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver); // Initialize Actions object
    }

    @FindBy(id="input-firstname")
    public static WebElement firstname;
    @FindBy(id="input-lastname")
    public static WebElement lastname;
    @FindBy(id="input-email")
    public static WebElement email;
    @FindBy(id="input-telephone")
    public static WebElement telephone;
    @FindBy(id="input-password")
    public static WebElement password;
    @FindBy(id="input-confirm")
    public static WebElement ConfirmPassword;
    @FindBy(xpath="//label[@for='input-agree']")
    public static WebElement Agree;
    @FindBy(xpath="//input[@class='btn btn-primary']")
    public static WebElement Continue;
    @FindBy(xpath = "//a[@class='btn btn-primary'][contains(text(), 'Continue')]")
    public static WebElement Continue2;

    public void inputFirstname(String Firstname) {
        firstname.sendKeys(Firstname);
    }
    public void inputLastname(String Lastname) {
        lastname.sendKeys(Lastname);
    }
    public void inputEmail(String Email) {
        email.sendKeys(Email);
    }
    public void inputTelephone(String phone) {
        telephone.sendKeys(phone);
    }
    public void inputPassword(String Password) {
        password.sendKeys(Password);
    }
    public void ConfirmPassword(String confirmPassword) {
        ConfirmPassword.sendKeys(confirmPassword);
    }
    public void clickAgree() {
        Agree.click();
    }
    public void clickContinue() {
        Continue.click();
    }
    public void clickContinue2() {
        Continue2.click();
    }
    // Explicit wait method
    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
