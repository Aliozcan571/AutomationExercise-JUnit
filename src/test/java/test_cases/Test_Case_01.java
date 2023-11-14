package test_cases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case_01 extends TestBase {


//  TEST SENARYOSU 1: Kullanıcıyı Kaydettirin


    @Test
    public void test01() throws InterruptedException {

//      **Bütün Test Case classlarda ilk İki Adımı parent classta oluşturdum**

    /*  1. Tarayıcıyı başlatın
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");      */


//      3.   Ana sayfanın başarılı bir şekilde görüntülendiğini doğrulayın
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";

            Assert.assertEquals(expecedTitle,actualTitle);


//      4.  'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        //driver.findElement(By.linkText("Signup / Login")).click();                   // 1.yol
        driver.findElement(By.xpath("//a[@href='/login']")).click();      // 2.yol


//      5.  'Yeni Kullanıcı Kaydı!' seçeneğinin görünür olduğunu doğrulayın
        WebElement yeniKullaniciKaydi = driver.findElement(By.xpath("(//h2)[3]"));

            Assert.assertTrue(yeniKullaniciKaydi.isDisplayed());

//      6.   Ad ve e-posta adresini girin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Ali Özcan");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys(faker.internet().emailAddress());


//      7.  'Kayıt Ol' butonuna tıklayın
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();


//      8.  'HESAP BİLGİLERİNİ GİRİN' seçeneğinin göründüğünü doğrulayın
        WebElement hesapBilgileriniGirin = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));

            Assert.assertTrue(hesapBilgileriniGirin.isDisplayed());


//      9.   Ayrıntıları girin: Unvan, İsim, E-posta, Şifre, Doğum Tarihi
//          (unvan, isim, e-posta otomatik geldi)

        driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("123456789");
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//option[@value=\"7\"])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//option[@value=\"5\"])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//option[@value=\"1990\"]")).click();


//      10. 'Bültenimize kaydolun!' onay kutusunu seçin.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name=\"newsletter\"]")).click();


//      11. 'Ortaklarımızdan özel teklifler alın!' onay kutusunu seçin.
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name=\"optin\"]")).click();


//      12.  Ayrıntıları doldurun: Ad, Soyadı, Şirket, Adres, Adres2, Ülke, Eyalet, Şehir, Posta Kodu, Cep Numarası
        driver.findElement(By.xpath("//input[@id=\"id_gender1\"]")).click();
        Thread.sleep(2500);
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
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@data-qa=\"create-account\"]")).click();


        driver.navigate().refresh();
//      14. 'HESAP OLUŞTURULDU!' ifadesini görünür olduğunu doğrulayın
        WebElement hesapOlusturuldu = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]"));

            Assert.assertTrue(hesapOlusturuldu.isDisplayed());

//      15. 'Devam' düğmesine tıklayın
        Thread.sleep(1500);
        driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]")).click();              //1.yol
        driver.navigate().refresh();


        driver.findElement(By.linkText("Continue")).click(); //reklamdan dolayı ikinci kez tıklanması gerek  //2.yol


//      16. 'Kullanıcı adı olarak oturum açıldı' seçeneğinin görünür olduğunu doğrulayın
        WebElement kullaniciAdi = driver.findElement(By.xpath("//*[contains(text(),'Ali Özcan')]"));

        Assert.assertTrue(kullaniciAdi.isDisplayed());


//      17. 'Hesabı Sil' butonuna tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href=\"/delete_account\"]")).click();


//      18. 'HESAP SİLİNDİ!' seçeneğinin görünür olduğunu doğrulayın ve 'Devam' düğmesine tıklayın
        WebElement hesapSilindi = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));

            Assert.assertTrue(hesapSilindi.isDisplayed());

        Thread.sleep(1500);
        driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]")).click(); //devam butonuna tıklama


    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(1500);
        //driver.close();
    }
}

