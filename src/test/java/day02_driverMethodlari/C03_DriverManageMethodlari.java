package day02_driverMethodlari;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");

        System.out.println("Baslangicta konum : " +driver.manage().window().getPosition());//(10, 10)
        System.out.println("Baslangicta boyut : " +driver.manage().window().getSize());// (1050, 652)

        Thread.sleep(1000);
        driver.manage().window().maximize();
        System.out.println("Maximize konum : " +driver.manage().window().getPosition());//(-8, -8)
        System.out.println("Maximize boyut : " +driver.manage().window().getSize());// (1296, 688)

        Thread.sleep(1000);
        driver.manage().window().fullscreen();
        System.out.println("Fullscreen konum : " +driver.manage().window().getPosition());//(0, 0)
        System.out.println("Fullscreen boyut : " +driver.manage().window().getSize());// (1280, 720)

        Thread.sleep(1000);
        driver.manage().window().minimize();
        System.out.println("Minimize konum : " +driver.manage().window().getPosition());//(10, 10)
        System.out.println("Minimize boyut : " +driver.manage().window().getSize());// (1050, 652)

        // pencereyi istedigimiz boyut ve konuma getirelim
        Thread.sleep(1000);
        driver.manage().window().setPosition(new Point(50,50));
        driver.manage().window().setSize(new Dimension(500,500));
        System.out.println("istedigimiz konum : " +driver.manage().window().getPosition());//(50, 50)
        System.out.println("istedigim boyut : " +driver.manage().window().getSize());// (515, 500)

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        Thread.sleep(3000);
        driver.close();
    }
}
