package login_validation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginValidation {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name")); // find username field
        username.sendKeys("standard_user"); // enter valid username
        WebElement password = driver.findElement(By.id("password")); // find password field
        password.sendKeys("secret_sauce"); //enter valid password
        WebElement loginbutton = driver.findElement(By.id("login-button"));  //find login button
        loginbutton.click(); // click on login button
        WebElement inventorycontainer = driver.findElement(By.id("inventory_container")); // find inventory container element using id
        Assert.assertTrue("Not Logged in Yet",inventorycontainer.isDisplayed()); // assertion to validate whether inventory container is being displayed or not
        if(inventorycontainer.isDisplayed()){
            System.out.println("log in successful and user is on inventory page");     // console output
        }

    }
}
