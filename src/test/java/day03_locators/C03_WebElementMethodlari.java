package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WebElementMethodlari {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // amazon anasayfaya gidip arama kutusunu locate edelim

        driver.get("https://www.amazon.com");
        WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));

        System.out.println(aramaKutusuElementi.isDisplayed());// true
        System.out.println(aramaKutusuElementi.isEnabled());// true

        System.out.println(aramaKutusuElementi.getText());

        Thread.sleep(3000);

        aramaKutusuElementi.sendKeys("Nutella");
        Thread.sleep(3000);
        aramaKutusuElementi.clear();

        System.out.println(aramaKutusuElementi.getSize());//(541, 38)
        System.out.println(aramaKutusuElementi.getSize().getHeight());//38

        System.out.println(aramaKutusuElementi.getTagName());//input
        System.out.println(aramaKutusuElementi.getAttribute("class"));// nav-input nav-progressive-attribute

        System.out.println(aramaKutusuElementi.getLocation());// (275, 10) - pixel olarak konumu -

        Thread.sleep(3000);
        driver.close();
    }
}
