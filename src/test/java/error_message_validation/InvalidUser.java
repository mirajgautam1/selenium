package error_message_validation;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class InvalidUser {
     public static void main(String[] args) {
          WebDriver driver = new ChromeDriver();
          driver.manage().window().maximize();
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.get("https://saucedemo.com/");
          WebElement usernameField = driver.findElement(By.id("user-name")); // find username field
          usernameField.sendKeys("randomuser");   // type invalid username
          WebElement passwordField = driver.findElement(By.id("password")); // find password field
          passwordField.sendKeys("random"); // type invalid  password
          WebElement loginButton = driver.findElement(By.id("login-button")); // find element login button
          loginButton.click();  // click login button
          WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")); //find errorMeesage element
          boolean result = errorMessage.isDisplayed(); // recognize whether error message is displayed or not
          Assert.assertTrue(result); // Assertion to find whether the test has passed or failed

          if(result){
               System.out.println("Is error message Displaying? " + result);  // display message whether error message is there or not (shows in either true or false)
          }


     }
}