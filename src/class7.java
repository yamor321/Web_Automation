import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.assertEquals;

public class class7 {

    private static WebDriver driver;

    @BeforeClass
    public static void BeforeTestClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\ירדן\\Automation\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
    }

    @Test
    public void test1() {

    }


    @Test
    public void test2() {
        driver.get("https://translate.google.co.il/?hl=iw");
        WebElement sha = driver.findElement(By.id("gt-submit"));
        System.out.println(sha.getTagName());
        System.out.println(sha.getSize().width);
        System.out.println(sha.isEnabled());
        System.out.println(sha.getAttribute("value"));
        driver.findElement(By.xpath("//textarea[@id='source']")).sendKeys("coin");
        sha.click();
        System.out.println(driver.findElement(By.id("gt-res-dir-ctr")).getAttribute("value"));
    }

    @AfterClass
    public static void AfterTestClass() {
        driver.quit();
    }
}