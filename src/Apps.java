import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Apps {

    private static AndroidDriver<MobileElement> driver;
    TouchAction action = new TouchAction(driver);

    @BeforeClass
    public static void setUp() throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability("appPackage", "com.android.chrome");
        capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void test1homework() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(driver.findElements(MobileBy.AndroidUIAutomator("new UiSelector().clickable(true)")));
        System.out.println(driver.getPageSource());
        List<MobileElement> listofclickbleelements = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)");
        for (MobileElement element : listofclickbleelements ){
            System.out.println(element.getLocation());
        }
        MobileElement elementbyclass = driver.findElement(MobileBy.className("android.widget.EditText"));
        System.out.println(elementbyclass.getText());


        System.out.println();
    }

    @Test
    public void test2homework(){
    System.out.println(driver.findElement(By.id("hplogo")).getSize());
    System.out.println(driver.findElement(By.id("hplogo")).getLocation());
    driver.pressKeyCode(AndroidKeyCode.HOME);
    driver.longPressKeyCode(AndroidKeyCode.KEYCODE_HOME);
    }

    @Test
    public void test3chall() throws InterruptedException {
        driver.findElementByAndroidUIAutomator(("new UiSelector().index(0).className(android.widget.EditText).clickable(true)")).sendKeys("banana");
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator(("new UiSelector().index(2).className(android.widget.Button).clickable(true)")).click();

    }

    @AfterClass
    public static void tearDown(){
//        driver.quit();
    }
}
