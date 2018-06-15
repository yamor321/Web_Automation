



import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class class8 {

    private static WebDriver driver;

    @BeforeClass
    public static void BeforeTestClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\ירדן\\Automation\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
       // options.addArguments("-incognito");
       // options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    @Test
    public void test2() {
        driver.get("https://translate.google.co.il/?hl=iw");
        WebElement sha = driver.findElement(By.id("gt-submit"));
        driver.findElement(By.xpath("//textarea[@id='source']")).sendKeys("coin");
        sha.click();
        WebDriverWait w = new WebDriverWait(driver,5);
        w.until(ExpectedConditions.visibilityOfAllElements());
        System.out.println(driver.findElement(By.id("result_box")).getAttribute("result_box"));
    }

    @AfterClass
    public static void AfterTestClass() {
     //   driver.quit();
    }
}