package Practices.BabayigitPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P4 {
    /*
Navigate to website https://testpages.herokuapp.com/styled/index.html
Under the ORIGINAL CONTENTS
click on Alerts
print the URL
navigate back
print the URL
Click on Basic Ajax
print the URL
enter value 20 and ENTER
and then verify Submitted Values is displayed open page
close driver
 */
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Navigate to website https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        //Under the ORIGINAL CONTENT click on Alerts
        WebElement alertElementi = driver.findElement(By.id("alerts"));
        alertElementi.click();

        //print the URL
        System.out.println("Current Url = " + driver.getCurrentUrl());

        //navigate back
        driver.navigate().back();
        Thread.sleep(2000);

        //print the URL
        System.out.println(driver.getCurrentUrl());

        //Click on Basic Ajax
        WebElement basicAjaxElementi = driver.findElement(By.id("basicajax"));
        basicAjaxElementi.click();
        Thread.sleep(2000);

        //print the URL
        System.out.println(driver.getCurrentUrl());

        //enter value 20 and ENTER
        driver.findElement(By.id("lteq30")).sendKeys("20");
        driver.findElement(By.xpath("//input[@name='submitbutton']")).click();


        //and then verify Submitted Values is displayed open page
        WebElement submittedValuesElementi = driver.findElement(By.xpath("//p[text()='Submitted Values']"));

        if (submittedValuesElementi.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        //close driver
        driver.close();
    }

}
