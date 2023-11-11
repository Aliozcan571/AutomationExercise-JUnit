package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case_02 extends TestBase {


//  TEST SENARYOSU 2: Kullanıcıya doğru e-posta ve şifreyle giriş yapın


    @Test
    public void test01() throws InterruptedException {

//      3. Ana sayfanın başarıyla göründüğünü doğrulayın
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";

        Assert.assertEquals(expecedTitle,actualTitle);

//      4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        driver.findElement(By.xpath("//a[@href='/login']")).click();

//      5. 'Hesabınıza giriş yapın' seçeneğinin görünür olduğunu doğrulayın
        WebElement hesabinizaGirisYapin = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(hesabinizaGirisYapin.isDisplayed());

//      6. Doğru e-posta adresini ve şifreyi girin
        driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys("kardeslerime.selam.571@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("123456");

//      7. 'Giriş yap' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();

//      8. 'Kullanıcı adı olarak oturum açıldı' seçeneğinin görünür olduğunu doğrulayın
        WebElement kullaniciAdi= driver.findElement(By.xpath("//*[contains(text(),'Ali Özcan')]"));
        Assert.assertTrue(kullaniciAdi.isDisplayed());

//      9. 'Hesabı Sil' düğmesine tıklayın
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href=\"/delete_account\"]")).click();

        driver.navigate().refresh();
        Thread.sleep(1000);

//      10. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. görünür
        WebElement hesapSilindi = driver.findElement(By.xpath("//*[contains(text(),'Account Deleted!')]"));
        Assert.assertTrue(hesapSilindi.isDisplayed());

        driver.findElement(By.xpath("//a[@data-qa=\"continue-button\"]")).click(); //devam butonuna tıklama

    }



}
