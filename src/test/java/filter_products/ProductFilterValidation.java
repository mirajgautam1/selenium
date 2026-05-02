package filter_products;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductFilterValidation {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://saucedemo.com/");
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginbutton = driver.findElement(By.id("login-button"));
        loginbutton.click();
        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        dropdown.click();
        WebElement descOption = driver.findElement(By.xpath("//option[@value='za']"));
        descOption.click();
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        List <String> productNames = new ArrayList<>();
        for(WebElement product : products){
            productNames.add(product.getText());
        }
        List <String> expectedNames = new ArrayList<>(productNames);
        expectedNames.sort(Collections.reverseOrder());
        Assert.assertEquals("Descending Filter for name failed",productNames,expectedNames);


    }
}
