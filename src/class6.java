import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class class6 {
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
        int a=2;
        int b=2;
        assertEquals(a,b);

    }

    @Test
    public void test2() {
        driver.get("http://www.walla.co.il/");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getWindowHandle());
        System.out.println("The Title is "+driver.getTitle());
        System.out.println("The Source is "+driver.getPageSource());
        assertEquals("https://www.walla.co.il/",driver.getCurrentUrl());
        System.out.println("sharon");
    }
    @AfterClass
    public static void AfterTestClass(){
        driver.quit();
    }
}
