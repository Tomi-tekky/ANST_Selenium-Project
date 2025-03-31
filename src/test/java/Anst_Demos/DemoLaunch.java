package Anst_Demos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoLaunch {

    private WebDriver driver;

    @BeforeClass
    public void setup(){

        WebDriverManager.firefoxdriver().setup(); //Auto-downloads the ChromeDriver
        driver = new FirefoxDriver();
        driver.manage().window().maximize(); //maximize window
    }

    @Test
    public void LoginPage() throws InterruptedException {
        driver.get("https://www.saucedemo.com/"); //Open url

        WebElement username = driver.findElement(By.id("user-name")); //Create WebElement for username
        username.sendKeys("standard_user"); //Input value into username field
        Thread.sleep(Long.parseLong("3000")); //Introduce wait for 3secs

        WebElement password = driver.findElement(By.id("password")); //Create WebElement for password
        password.sendKeys("secret_sauce"); //Input value into username field
        Thread.sleep(Long.parseLong("3000")); //Introduce wait for 3secs

        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click(); //click on LoginButton
        Thread.sleep(Long.parseLong("3000")); //Introduce wait for 3secs
    }
}
