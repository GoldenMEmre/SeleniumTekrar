package Practices.BabayigitPractice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P5 {
    /*
    1-Driver oluşturalim
    2-Java class'imiza chnomedriver. exetyi tanitalim
    3-Driver'in tum ekranı kaplamasini sagu ayalim
    4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
     Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.
    5-Navigate to http://www.babayigit.net/murat/testpage.html
    6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
        alanlarına gerekli bilgileri yazsın
    7-Submit tuşuna bassın.
    8- All information was entered correctly.. yazısının göründüğünü test etsin
    9- Clear butonu ile tüm butonları temizlesin
    10- Manuel olarak temizlendiğini görecek kadar beklesin
    11- Sayfayı kapatsın
    10-8. maddededeki Test sonucunu yazdırsın
     */
    public static void main(String[] args) throws InterruptedException {

        // 1-Driver oluşturalim
        // 2-Java class'imiza chnomedriver. exetyi tanitalim
        // 3-Driver'in tum ekranı kaplamasini sagu ayalim
        // 4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
        // Eger oncesinde sqyfa Yüklenirse, beklemeyi bıraksın.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 5-Navigate to http://www.babayigit.net/murat/testpage.html
        driver.navigate().to("http://www.babayigit.net/murat/testpage.html");

        // 6-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children
        // alanlarına gerekli bilgileri yazsın
        driver.findElement(By.id("ad")).sendKeys("Murat");
        driver.findElement(By.id("soyad")).sendKeys("Babayiğit");
        driver.findElement(By.id("yas")).sendKeys("42");
        driver.findElement(By.id("meslek")).sendKeys("SDET");
        driver.findElement(By.id("dogum_yeri")).sendKeys("İstanbul");
        driver.findElement(By.id("mezun_okul")).sendKeys("Uludağ Üniversitesi");
        driver.findElement(By.id("cocuk_sayisi")).sendKeys("2");
        Thread.sleep(3000);

        // 7-Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@value='Submit']")).submit();

        // 8- All information was entered correctly.. yazısının göründüğünü test etsin
        WebElement allinformationYaziElementi = driver.findElement(By.id("uyari"));
        System.out.println(allinformationYaziElementi.getText());

        if (allinformationYaziElementi.isDisplayed()) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
        }

        // 9- Clear butonu ile tüm butonları temizlesin
        driver.findElement(By.xpath("//*[@value='Clear']")).click();

        // 10- Manuel olarak temizlendiğini görecek kadar beklesin
        Thread.sleep(3000);

        // 11- Sayfayı kapatsın
        driver.close();

        // 10-8. maddededeki Test sonucunu yazdırsın
        System.out.println("All information was entered correctly..");


    }
}

