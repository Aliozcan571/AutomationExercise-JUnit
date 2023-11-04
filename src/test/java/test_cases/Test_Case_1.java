package test_cases;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_Case_1 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        Faker faker = new Faker();

/*
        TEST SENARYOSU 1: Kullanıcıyı Kaydettirin
*/

//      1.   Tarayıcıyı başlatın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//      2.  'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");


//      3.   Ana sayfanın başarılı bir şekilde görüntülendiğini doğrulayın
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";


        if (actualTitle.equals(expecedTitle)){
            System.out.println("TEST PASSED ===> Ana Sayfa Görüldü");
        }else {
            System.out.println("TEST FAILED ===> Ana Sayfa Görülmedi");
        }


//      4.  'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        //driver.findElement(By.linkText("Signup / Login")).click();                   // 1.yol
        driver.findElement(By.xpath("//a[@href='/login']")).click();      // 2.yol


//      5.  'Yeni Kullanıcı Kaydı!' seçeneğinin görünür olduğunu doğrulayın
        WebElement yeniKullaniciKaydi = driver.findElement(By.xpath("(//h2)[3]"));

        if (yeniKullaniciKaydi.isDisplayed()){
            System.out.println("TEST PASSED ===> Yeni Kullanıcı Kaydı Seçeneği Görüldü");
        }else {
            System.out.println("TEST FAILED ===> Yeni Kullanıcı Kaydı Seçeneği Görülmedi");
        }


//      6.   Ad ve e-posta adresini girin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Ali Özcan");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys(faker.internet().emailAddress());


//      7.  'Kayıt Ol' butonuna tıklayın
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();


//      8.  'HESAP BİLGİLERİNİ GİRİN' seçeneğinin göründüğünü doğrulayın
        WebElement hesapBilgileriniGirin =driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));

        if (hesapBilgileriniGirin.isDisplayed()){
            System.out.println("TEST PASSED ===> Hesap Bilgileri Seçeneği Görüldü");
        }else {
            System.out.println("TEST FAILED ===> Hesap Bilgileri Seçeneği Görülmedi");
        }


//      9.   Ayrıntıları girin: Unvan, İsim, E-posta, Şifre, Doğum Tarihi
//          (unvan, isim, e-posta otomatik geldi)

        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("123456789");
        driver.findElement(By.xpath("(//option[@value=\"7\"])[1]")).click();
        driver.findElement(By.xpath("(//option[@value=\"5\"])[2]")).click();
        driver.findElement(By.xpath("//option[@value=\"1990\"]")).click();


//      10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@name=\"newsletter\"]")).click();


//      11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        driver.findElement(By.xpath("//input[@name=\"optin\"]")).click();


//      12.  Ayrıntıları doldurun: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"first_name\"]")).sendKeys("Ali");
        driver.findElement(By.xpath("//input[@id=\"last_name\"]")).sendKeys("Özcan");
        driver.findElement(By.xpath("//input[@id=\"company\"]")).sendKeys("Techpro");
        driver.findElement(By.xpath("//input[@id=\"address1\"]")).sendKeys("9 E Loockerman St Suite 311");
        driver.findElement(By.xpath("//input[@id=\"address2\"]")).sendKeys("Dover, DE 19901, ABD");
        driver.findElement(By.xpath("//option[@value=\"United States\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"state\"]")).sendKeys("Delaware");
        driver.findElement(By.xpath("//input[@id=\"city\"]")).sendKeys("Dover");
        driver.findElement(By.xpath("//input[@id=\"zipcode\"]")).sendKeys("19901");
        driver.findElement(By.xpath("//input[@id=\"mobile_number\"]")).sendKeys("+15853042959");


//      13. 'Hesap Oluştur düğmesi'ne tıklayın
        driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();


//      14. 'HESAP OLUŞTURULDU!' ifadesini görünür olduğunu doğrulayın
        WebElement hesapOlusturuldu = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));

        System.out.println(
                hesapOlusturuldu.isDisplayed() ? "TEST PASSED ===> Hesap Oluşturuldu" : "TEST FAILED ===> Hesap Oluşturulamadı");


//      15. 'Devam' düğmesine tıklayın
        driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]")).click();              //1.yol
        driver.navigate().refresh();
        driver.findElement(By.linkText("Continue")).click(); //reklamdan dolayı ikinci kez tıklanması gerek  //2.yol


//      16. 'Kullanıcı adı olarak oturum açıldı' seçeneğinin görünür olduğunu doğrulayın
        WebElement kullaniciAdi= driver.findElement(By.xpath("//*[contains(text(),'Ali Özcan')]"));

        if (kullaniciAdi.isDisplayed()){
            System.out.println("TEST PASSED ===> Kullanıcı olarak hesap açıldı");
        }else {
            System.out.println("TEST FAILED ===> Kullanıcı olarak hesap açılamadı");
        }


//      17. 'Hesabı Sil' butonuna tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href=\"/delete_account\"]")).click();


//      18. 'HESAP SİLİNDİ!' seçeneğinin görünür olduğunu doğrulayın ve 'Devam' düğmesine tıklayın
        WebElement hesapSilindi = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));

        if (hesapSilindi.isDisplayed()){
            System.out.println("TEST PASSED ===> Hesap Silindi");
        }else {
            System.out.println("TEST FAILED ===> Hesap Silinemedi ");
        }

        driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]")).click(); //devam butonuna tıklama

        Thread.sleep(1000);

        driver.close();





    }
}
