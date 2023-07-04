package Practices.SelfPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P05_WebdriverMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //(SDN) P.31
        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("http://www.youtube.com");
        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("Sayfa basligi : 'youtube', test PASSED");
        }else {
            System.out.println("Sayfa basligi : 'youtube' degil, test FAILED");
        }
        System.out.println("Actual Title : " + driver.getTitle());

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa doğru URL'yi yazdırın.
        String expectedUrl = "youtube";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url 'youtube' iceriyor, test PASSED");
        }else {
            System.out.println("Url 'youtube' icermiyor, test FAILED");
        }
        System.out.println("Actual Url : " + driver.getCurrentUrl());

        Thread.sleep(3000);
        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        Thread.sleep(3000);
        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        Thread.sleep(3000);
        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        Thread.sleep(3000);
        //7. Amazon sayfasina donun
        driver.navigate().forward();

        Thread.sleep(3000);
        //8. Sayfayi tamsayfa yapin
        driver.manage().window().maximize();

        Thread.sleep(3000);
        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        // Yoksa doğru başlığı(Actual Title) yazdırın.
        expectedTitle = "Amazon";
        actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Sayfa basligi 'Amazon' iceriyor, test PASSED");
        } else {
            System.out.println("Sayfa basligi 'Amazon' icermiyor, test FAILED");
        }
        System.out.println(driver.getTitle());

        Thread.sleep(3000);
        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse doğru URL'yi yazdırın
        expectedUrl = "https://www.amazon.com/";
        actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("Sayfa URL : https://www.amazon.com/");
        } else {
            System.out.println("Sayfa URL : https://www.amazon.com/ degil");
        }
        System.out.println("Actaul Url : " + driver.getCurrentUrl());

        Thread.sleep(3000);
        //11.Sayfayi kapatin
        driver.close();

    }
}
