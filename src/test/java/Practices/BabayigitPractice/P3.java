package Practices.BabayigitPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P3 {

    /* ...Exercise3...
Navigate to  https://testpages.herokuapp.com/styled/index.html
Click on  Calculater under Micro Apps
Type any number in the first input
Type any number in the second input
Click on Calculate
Get the result
Print the result
      */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        //Click on  Calculater under Micro Apps
        WebElement calculatorElementi = driver.findElement(By.id("calculatetest"));
        calculatorElementi.click();

        //Type any number in the first input
        driver.findElement(By.name("number1")).sendKeys("10");

        //Type any number in the second input
        driver.findElement(By.name("number2")).sendKeys("10");

        //Click on Calculate
        driver.findElement(By.xpath("//input[@value='Calculate']")).click();

        //Get the result
        //Print the result
        WebElement resultElementi = driver.findElement(By.id("answer"));
        System.out.println(resultElementi.getText());

    }
}
