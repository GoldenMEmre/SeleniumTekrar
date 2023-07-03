package Practices.SelfPractice;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P03_DriverManage {
    public static void main(String[] args) {

        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
                    //(SDN) P.29
        // 2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        // 3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Konum : " + driver.manage().window().getPosition());// Konum : (10, 10)
        System.out.println("Boyut : " + driver.manage().window().getSize());// Boyut : (1050, 652)

        // 4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        driver.manage().window().setPosition(new Point(20,20));
        driver.manage().window().setSize(new Dimension(800,400));

        System.out.println("istenen konum : " + driver.manage().window().getPosition());
        System.out.println("istenen boyut : " + driver.manage().window().getSize());


        // 5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Point newPosition = driver.manage().window().getPosition();
        Dimension newSize = driver.manage().window().getSize();
        if (newPosition.equals(new Point(20, 20)) && newSize.equals(new Dimension(800, 400))) {
            System.out.println("Sayfa başarıyla istenen konum ve boyuta geldi.");
        } else {
            System.out.println("Sayfa konumu ve boyutu değiştirilemedi.");
        }
        driver.close();


    }
}
