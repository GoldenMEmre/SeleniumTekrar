package day05_relativeLocators_maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_ZeroWebapp {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //2. Signin buttonuna tiklayin
        WebElement signinButonuElementi = driver.findElement(By.className("icon-signin"));
        signinButonuElementi.click();

        //3. Login alanine  “username” yazdirin
        WebElement loginElementi = driver.findElement(By.xpath("//input[@name='user_login']"));
        loginElementi.sendKeys("username");

        //4. Password alanina “password” yazdirin
        WebElement passwordElementi = driver.findElement(By.xpath("//input[@name='user_password']"));
        passwordElementi.sendKeys("password");

        //5. Sign in buttonuna tiklayin
        WebElement signinElementi = driver.findElement(By.xpath("//input[@name='submit']"));
        signinElementi.click();

        //6. Back tusu ile sayfaya donun
        driver.navigate().back();

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        WebElement onlineBankingElementi = driver.findElement(By.id("onlineBankingMenu"));
        onlineBankingElementi.click();
        WebElement payBillsElementi = driver.findElement(By.id("pay_bills_link"));
        payBillsElementi.click();

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.id("sp_amount")).sendKeys("25");

        //9. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");

        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin
        WebElement paymentSubmitElementi= driver.findElement(By.id("alert_content"));

        if (paymentSubmitElementi.isDisplayed()){
            System.out.println("Payment Submitted testi PASSED");
        } else {
            System.out.println("Payment Submitted testi FAILED");
        }
        Thread.sleep(3000);
        driver.close();



    }
}
