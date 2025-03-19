import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Wait {
    private WebDriver driver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup(); //Auto-downloads the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //maximize window
    }

    @Test
    public void ImplicitWait() throws InterruptedException {
        driver.get("https://www.saucedemo.com/"); //Open url

        //Create WebElement object for username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user"); //Input value into username field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Driver is going to wait for 3 seconds before taking the next action

        //Create WebElement object for password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce"); //Input value into username field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Driver is going to wait for 3 seconds before taking the next action

        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click(); //click on LoginButton
        Thread.sleep(Long.parseLong("3000")); //Introduce wait for 3secs
    }
    @Test
    public void ExplicitWait() throws InterruptedException {
        driver.get("https://www.saucedemo.com/"); //Open url

        //Create WebElement object for username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user"); //Input value into username field

        //Create WebDriverWait instance with a timeout of 10 seconds
        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        //Wait until the element is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));

        //Create WebElement object for password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce"); //Input value into username field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Driver is going to wait for 3 seconds before taking the next action


        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click(); //click on LoginButton
        Thread.sleep(Long.parseLong("3000")); //Introduce wait for 3secs
    }
    @Test
    public void TearDownTestBrowser(){
        driver.close();
    }
}
