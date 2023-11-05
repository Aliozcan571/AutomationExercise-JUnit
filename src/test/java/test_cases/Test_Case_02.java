package test_cases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case_02 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();


//        TEST SENARYOSU 2: Kullanıcıya doğru e-posta ve şifreyle giriş yapın


//        1. Tarayıcıyı başlatın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//        2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");

//        3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";

        if (actualTitle.equals(expecedTitle)){
            System.out.println("TEST PASSED ===> Ana Sayfa Görüldü");
        }else {
            System.out.println("TEST FAILED ===> Ana Sayfa Görülmedi");
        }

//        4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//        5. 'Hesabınıza giriş yapın' seçeneğinin görünür olduğunu doğrulayın
        WebElement hesabinizaGirisYapin = driver.findElement(By.xpath("(//h2)[1]"));

        if (hesabinizaGirisYapin.isDisplayed()){
            System.out.println("TEST PASSED ===> Hesabınıza giriş yapın seçeneği görüldü");
        }else {
            System.out.println("TEST FAILED ===> Hesabınıza giriş yapın seçeneği görülmedi");
        }

//        6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys("kardeslerime.selam.571@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("123456789");

//        7. 'Giriş yap' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();

//        8. 'Kullanıcı adı olarak oturum açıldı' seçeneğinin görünür olduğunu doğrulayın
        WebElement kullaniciAdi= driver.findElement(By.xpath("//*[contains(text(),'Ali Özcan')]"));

        if (kullaniciAdi.isDisplayed()){
            System.out.println("TEST PASSED ===> Kullanıcı olarak hesap açıldı");
        }else {
            System.out.println("TEST FAILED ===> Kullanıcı olarak hesap açılamadı");
        }

//        9. 'Hesabı Sil' düğmesine tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href=\"/delete_account\"]")).click();

//        10. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. görünür
        WebElement hesapSilindi = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));

        if (hesapSilindi.isDisplayed()){
            System.out.println("TEST PASSED ===> Hesap Silindi");
        }else {
            System.out.println("TEST FAILED ===> Hesap Silinemedi ");
        }

        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]")).click(); //devam butonuna tıklama

        Thread.sleep(1000);
        driver.close();






    }
}
