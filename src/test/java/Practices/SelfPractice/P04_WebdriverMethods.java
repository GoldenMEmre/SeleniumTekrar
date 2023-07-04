package Practices.SelfPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P04_WebdriverMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //(SDN) P.30
        // 2.ChromeDriver kullanarak, facebook sayfasina gidin ve sayfa basliginin (title) “facebook” oldugunu
        // dogrulayin (verify), degilse dogru basligi yazdirin.
        driver.get("https://www.facebook.com");
        String expectedIcerik = "facebook";
        String actualIcerik = driver.getTitle();

        if (expectedIcerik.equals(actualIcerik)) {
            System.out.println("Sayfa basligi : facebook, test PASSED");
        } else {
            System.out.println("Sayfa basligi : facebook degil, test FAILED");
        }

        System.out.println("Dogru Baslik : " + driver.getTitle());

        // 3.Sayfa URL’inin “facebook” kelimesi icerdigini dogrulayin, icermiyorsa “actual” URL’i yazdirin.
        expectedIcerik = "facebook";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedIcerik)) {
            System.out.println("URL 'facebook' iceriyor, test PASSED");
        } else {
            System.out.println("URL 'facebook' icermiyor, test FAILED");
        }
        System.out.println("Actual Url : " + driver.getCurrentUrl());

        // 4.https://www.walmart.com/ sayfasina gidin.
        driver.get("https://www.walmart.com/");

        // 5. Sayfa basliginin “Walmart.com” icerdigini dogrulayin.
        expectedIcerik = "Walmart.com";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Sayfa basligi 'Walmart.com' iceriyor, test PASSED");
        } else {
            System.out.println("Sayfa basligi 'Walmart.com' icermiyor, test FAILED");
        }

        // 6. Tekrar “facebook” sayfasina donun
        driver.navigate().back();

        Thread.sleep(3000);
        // 7. Sayfayi yenileyin
        driver.navigate().refresh();

        Thread.sleep(3000);
        //8. Sayfayi tam sayfa (maximize) yapin
        driver.manage().window().maximize();

        Thread.sleep(3000);
        //9.Browser’i kapatin
        driver.close();


    }
}

