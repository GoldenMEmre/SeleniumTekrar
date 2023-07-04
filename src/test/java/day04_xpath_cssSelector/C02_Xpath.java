package day04_xpath_cssSelector;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Xpath {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        //2- Add Element butonuna basin
        Thread.sleep(3000);
        WebElement addElementi = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementi.click();

        //3- Delete butonu’nun gorunur oldugunu test edin
        WebElement deleteElementi = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));

        if (deleteElementi.isDisplayed()){
            System.out.println("Delete button testi PASSED");
            }else {
            System.out.println("Delete button testi FAILED");
        }

        Thread.sleep(3000);
        //4- Delete tusuna basin
        deleteElementi.click();

        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin
        WebElement addRemoveElementi = driver.findElement(By.xpath("//h3"));
        //driver.findElements(By.tagName("h3"));

        if (addRemoveElementi.isDisplayed()){
            System.out.println("Add/Remove Elements testi PASSED");
        }else {
            System.out.println("Add/Remove Elements testi FAILED");
        }

        Thread.sleep(3000);
        driver.close();
    }
}
