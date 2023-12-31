package Practices.BabayigitPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P7 {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");

        //2 ) Nurse  3 farkli relative locator ile locate edin
        //3 ) Relative locator’larin dogru calistigini test edin

        // A- tag'i img, Seller'in üstünde
        WebElement Seller = driver.findElement(By.id("sll_thumb"));
        WebElement nurse1 = driver.findElement(RelativeLocator.with(By.tagName("img")).above(Seller));

        if (nurse1.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Test1 PASSED");
        }else {
            System.out.println("Test1 FAILED");
        }

        // B- tag'i img, Fireman'in sağında
        WebElement Fireman = driver.findElement(By.id("frmn_thumb"));
        WebElement nurse2 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(Fireman));

        if (nurse2.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Test2 PASSED");
        }else {
            System.out.println("Test2 FAILED");
        }


        // C- tag'i img,Policeman'in sağında
        WebElement Policeman = driver.findElement(By.id("pol_thumb"));
        WebElement nurse3 = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(Policeman));

        if (nurse3.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Test3 PASSED");
        }else {
            System.out.println("Test3 FAILED");
        }
    }
}