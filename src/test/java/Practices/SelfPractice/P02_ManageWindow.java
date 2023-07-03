package Practices.SelfPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P02_ManageWindow {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
                    //(SDN) P.28
        // 2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // 3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Konum : " + driver.manage().window().getPosition());//(10, 10)
        System.out.println("Boyut : " + driver.manage().window().getSize());// (1050, 652)

        // 4. Sayfayi simge durumuna getirin
        driver.manage().window().minimize();

        // 5. simge durumunda 3 saniye bekleyip sayfayi maximize yapin
        Thread.sleep(3000);
        driver.manage().window().maximize();

        // 6. Sayfanin konumunu ve boyutlarini maximize durumunda yazdirin
        System.out.println("Maximize Konum : " + driver.manage().window().getPosition());//Maximize Konum : (-8, -8)
        System.out.println("Maximize Boyut : " + driver.manage().window().getSize());// Maximize Boyut : (1296, 688)

        // 7. Sayfayi fullscreen yapin
        driver.manage().window().fullscreen();

        // 8. Sayfanin konumunu ve boyutlarini fullscreen durumunda yazdirin
        System.out.println("Fullscreen Konum : " + driver.manage().window().getPosition());//Fullscreen Konum : (0, 0)
        System.out.println("Fullscreen Boyut : " + driver.manage().window().getSize());// Fullscreen Boyut : (1280, 720)

        // 9. Sayfayi kapatin
        driver.close();

    }
}
