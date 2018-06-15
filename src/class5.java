import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class class5 {
    static WebDriver driver;
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\ירדן\\Automation\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.walla.co.il");

    }
}
