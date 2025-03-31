package Anst_Demos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Assertion {
    private WebDriver driver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup(); //Auto-downloads the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //maximize window
    }

    @Test
    public void HardAssert() throws InterruptedException {
        driver.get("https://www.saucedemo.com/"); //Open url

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user"); //Input value into username field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Driver is going to wait for 3 seconds before taking the next action
        Assert.assertEquals(username.getAttribute("value"),"standard_user","Username is incorrect");

        //Create WebElement object for password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce"); //Input value into username field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Driver is going to wait for 3 seconds before taking the next action

        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click(); //click on LoginButton
        Thread.sleep(Long.parseLong("3000")); //Introduce wait for 3secs

    }
    @Test
    public void SoftAssert() throws InterruptedException {
        driver.get("https://www.saucedemo.com/"); //Open url
        SoftAssert softAssert = new SoftAssert();
        String PageTitle = driver.getTitle();

        softAssert.assertEquals(PageTitle,"Swag lab","Title is incorrect");

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user"); //Input value into username field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Driver is going to wait for 3 seconds before taking the next action
        softAssert.assertEquals(username.getAttribute("value"),"standard_user","Username is incorrect");

        //Create WebElement object for password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce"); //Input value into username field
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Driver is going to wait for 3 seconds before taking the next action

        driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click(); //click on LoginButton
        Thread.sleep(Long.parseLong("3000")); //Introduce wait for 3secs

        softAssert.assertAll(); //Report all failures at the end of your test

    }
    @Test
    public void TearDownTestBrowser(){
        driver.close();
    }
}
