import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pack.Constants;
import pack.POMexe;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class class9 {
    private static WebDriver driver;
    static  POMexe poMexe;

    public static void main(String[] args) {
         poMexe = PageFactory.initElements(driver,POMexe.class);
//        System.out.println(Constants.MY_ID);
//        driver.findElement(Constants.sha).click();
//        POMexe.presslog(driver);

    }

    @BeforeClass
    public static void BeforeTestClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\ירדן\\Automation\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        // options.addArguments("-incognito");
        // options.addArguments("--disable-popup-blocking");
//        driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void test2() throws IOException {

        //poMexe.loginButton.click();

        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\ירדן\\Automation\\intellij\\class9txt.txt"));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            System.out.println(everything);
        } finally {
            br.close();

        }
    }

    @AfterClass
    public static void AfterTestClass() {
        //   driver.quit();
    }
}

