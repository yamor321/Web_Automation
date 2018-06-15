package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class POMexe {

    private static WebElement element = null;

//public static void presslog(WebDriver driver){
//        element = driver.findElement(By.id("login"));
//        element.click();
//    }
//
//    public static void presslog2(WebDriver driver){
//        element = driver.findElement(By.id("fjy"));
//        element.click();

    WebDriver driver;

    @FindBy(how = How.ID,using = "login")
     public WebElement loginButton;

    public POMexe(WebDriver driver) {
        this.driver = driver;
    }
}
