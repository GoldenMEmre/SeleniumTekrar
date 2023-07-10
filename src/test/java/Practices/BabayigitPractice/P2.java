package Practices.BabayigitPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P2 {
    /*
     . .Exercise2...
    1-Driver oluşturalim
    2-Java class'imiza chromedriver. exe'yi tanitalim
    3-Driver'in tum ekranı kaplamasini saglayalim
    4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
     Eger oncesinde sayfa yüklenirse, beklemeyi bıraksın.
    5-"https://www.otto.de" adresine gidelim
    6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
    7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
    8-Ardindan "https://wisequarter.com/" adresine gidip
    9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
    10-Bir onceki web sayfamiza geri donelim
    11-Sayfayı yenileyelim
    12-Daha sonra web sgyfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
    13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
    public static void main(String[] args) throws InterruptedException {

    // 1-Java class'imiza chromedriver. exe'yi tanitalim
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32/chromedriver.exe");

    // 2-Driver oluşturalim
        WebDriver driver = new ChromeDriver();

    // 3-Driver'in tum ekranı kaplamasini saglayalim
        driver.manage().window().maximize();

    // 4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
    // Eger oncesinde sayfa yüklenirse, beklemeyi bıraksın.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10));

    // 5-"https://www.otto.de" adresine gidelim
        driver.get("https://www.otto.de");

    // 6-BU web adresinin sayfa basligini (title) ve adres (url)ini alalim
        String ottoTitle = driver.getTitle();
        System.out.println("Otto Title = " + ottoTitle);
        String ottoUrl = driver.getCurrentUrl();
        System.out.println("Otto Url = " + ottoUrl);

    // 7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
        String expectedIcerik = "OTTO";
        String actualTitle = driver.getTitle();
        String actualUrl = driver.getCurrentUrl();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title OTTO kelimesini içeriyor, test PASSED");
        }else {
            System.out.println("Title OTTO kelimesini içermiyor, test FAILED");
        }

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Url OTTO kelimesini içeriyor, test PASSED");
        } else {
            System.out.println("Url OTTO kelimesini içermiyor, test FAILED");
        }
    // 8-Ardindan "https://wisequarter.com/" adresine gidip
        driver.get("https://wisequarter.com/");

    // 9-BU adresin basligini alalim ve "Quarter" kelimesini icenip icermedigini kontrol edelim
        String expectedKelime = "Quarter";
        String actualBaslik = driver.getTitle();

        if (actualBaslik.contains(expectedKelime)){
            System.out.println("Baslik Quarter kelimesini içeriyor, test PASSED");
        } else {
            System.out.println("Baslik Quarter kelimesini içermiyor, test FAILED");
        }
    // 10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();
        Thread.sleep(2000);

    // 11-Sayfayı yenileyelim
        driver.navigate().refresh();
        Thread.sleep(2000);

    // 12-Daha sonra web sgyfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();
        Thread.sleep(2000);

    // 13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();

    }
}
