package Anst_Demos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectDropDown {
    private WebDriver driver;

    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup(); //Auto-downloads the ChromeDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //maximize window
    }

    @Test
    public void DropDownTest() throws InterruptedException {
        driver.get("https://www.sugarcrm.com/uk/request-demo/"); //Open url
        Thread.sleep(Long.parseLong("3000"));
        driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();

        WebElement companySize = driver.findElement(By.name("input_8")); //Instantiating an object for the WebElement company size

        Select select = new Select(companySize);
        select.selectByIndex(7); //select 1,001 - 2,500 employees
        Thread.sleep(Long.parseLong("3000"));
        select.selectByVisibleText("501 - 1,000 employees"); //select 501 - 1000 employees
        Thread.sleep(Long.parseLong("3000"));
        select.selectByValue("level2"); //select 501 - 1000 employees
        Thread.sleep(Long.parseLong("3000"));
    }
    @Test
    public void TearDownTestBrowser(){
        driver.close();
    }
}
