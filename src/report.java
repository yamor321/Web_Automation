import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;

    @FixMethodOrder(MethodSorters.NAME_ASCENDING)
    public class report {


        @Rule
        public TestName name = new TestName();

        private static ChromeDriver driver;

        // create ExtentReports and attach reporter(s)
        private static ExtentReports extent ;

        // creates a toggle for the given test, adds all log events under it
        private static ExtentTest test ;

        @BeforeClass
        public static void beforeClass() {

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C:\\Users\\user\\Desktop\\ירדן\\Automation\\extent\\extent.html");

            // choose to append each test
            htmlReporter.setAppendExisting(true);
            // attach reporter
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            // name your test and add description
            test = extent.createTest("MyFirstTest", "Sample description");

            // add custom system info
            extent.setSystemInfo("Environment", "Production");
            extent.setSystemInfo("Tester", "Daniel");

            // log results
            test.log(Status.INFO, "@Before class");

            boolean driverEstablish = false;
            try {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\user\\Desktop\\ירדן\\Automation\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                driver = new ChromeDriver(options);

                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                driver.manage().window().maximize();
                driverEstablish = true;


            } catch (Exception e) {
                e.printStackTrace();
                fail("Cant connect chromeDriver");
                test.log(Status.FATAL, "Driver Connection Failed! " + e.getMessage());
                driverEstablish = false;
            } finally {
                if (driverEstablish) {
                    test.log(Status.PASS, "Driver established successfully");

                }
            }
        }


        @Test
        public void test1_openPage() {
            boolean pageOpened = false;
            try {
                driver.get("https://translate.google.com/");
                String firstWindowString = driver.getWindowHandle();
                System.out.println("Window String: " + firstWindowString);
                pageOpened = true;

            } catch (Exception e) {
                e.printStackTrace();
                test.log(Status.FAIL, "Google Translate page was not found " + e.getMessage());
                pageOpened = false;
            } finally {
                if (pageOpened) {
                    test.log(Status.PASS, "Open webpage " + "Webpage opened successfully");

                }
            }
        }

        @Test
        public void test2_clickButton() throws IOException {

            // add screenshot
            test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Users\\user\\Desktop\\ירדן\\Automation\\extent\\extent.html" + name.getMethodName())).build());


            boolean pressed = false;
            try {
                driver.findElement(By.id("gt-submit")).click();
                pressed = true;
            } catch (Exception e) {
                e.printStackTrace();
                test.log(Status.FAIL, "Translate button was not clicked " + e.getMessage());
                pressed = false;
            } finally {
                if (pressed) {
                    test.log(Status.PASS, "Translate button click " + "Translate button was clicked successfully");

                }
            }
        }

        @Test
        public void numberExceptionTest(){


            try {
                int a = 1 / 0;
            } catch (ArithmeticException e) {
                test.log(Status.FAIL, "NumberException " + e.getMessage());
            }
        }

        @AfterClass
        public static void afterClass() {
            test.log(Status.INFO, "@After test " + "After test method");
            driver.quit();
            // build and flush report
            extent.flush();
        }

        private static String takeScreenShot(String ImagesPath) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
            File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File destinationFile = new File(ImagesPath+".png");
            try {
                FileUtils.copyFile(screenShotFile, destinationFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            return ImagesPath+".png";
        }

    }

