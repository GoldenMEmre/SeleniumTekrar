package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_GoogleNutella {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");

        //3- cookies uyarisini kabul ederek kapatin
        //cookies cikmadigi icin PASS gecildi. Eger ciksaydi;
        //driver.findElement(By.xpath("xpathExpression")).click();
        //4- Sayfa basliginin “Google” ifadesi icerdigini test edin
        String expectedIcerik= "Google";
        String actualIcerik = driver.getTitle();

        if (actualIcerik.contains(expectedIcerik)){
            System.out.println("icerik testi PASSED");
        } else {
            System.out.println("icerik testi FAILED");
        }

        //5- Arama cubuguna “Nutella” yazip aratin
        WebElement aramacubuguElementi = driver.findElement(By.xpath("//*[@name='q']"));
        aramacubuguElementi.sendKeys("Nutella");
        aramacubuguElementi.submit();

        //6- Bulunan sonuc sayisini yazdirin
        WebElement sonucSayisiElementi = driver.findElement(By.id("result-stats"));
        System.out.println(sonucSayisiElementi.getText());

        //7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucYazisiStr = sonucSayisiElementi.getText();
        String [] sonucYaziKelimeleriArr = sonucYazisiStr.split(" ");
        String sonucSayiAdediStr = sonucYaziKelimeleriArr[1];
        sonucSayiAdediStr = sonucSayiAdediStr.replaceAll("\\D","");
        int sonucSayisiInt= Integer.parseInt(sonucSayiAdediStr);

        if (sonucSayisiInt>10000000){
            System.out.println("sonuc sayisi testi PASSED");
        }else{
            System.out.println("Sonuc sayisi testi FAILED");
        }

        //8- Sayfayi kapatin
        Thread.sleep(3000);
        driver.close();




    }
}
