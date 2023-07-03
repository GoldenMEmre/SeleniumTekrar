package Practices.SelfPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P01_NavigationMethods {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

            //SELENIUM DERS NOTU (SDN) P.25
        // 2. Youtube ana sayfasina gidelim . https://www.youtube.com/
        driver.get("https://www.youtube.com/");

        // 3. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // 4. Tekrar YouTube’sayfasina donelim
        driver.navigate().back();

        // 5. Yeniden Amazon sayfasina gidelim
        driver.navigate().forward();

        // 6. Sayfayi Refresh(yenile) yapalim
        driver.navigate().refresh();

        Thread.sleep(3000);
        // 7. Sayfayi kapatalim / Tum sayfalari kapatalim
        driver.close();



    }
}
