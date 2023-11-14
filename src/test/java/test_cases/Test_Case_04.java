package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case_04 extends TestBase {


//   TEST SENARYOSU 4: Kullanıcı Oturumunu Kapatma

    @Test
    public void test01() {

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
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("1234567");

//      7. 'Giriş yap' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();

//      8. 'Kullanıcı adı olarak oturum açıldı' seçeneğinin görünür olduğunu doğrulayın
        WebElement kullaniciAdi= driver.findElement(By.xpath("//*[contains(text(),'Ali Özcan')]"));
        Assert.assertTrue(kullaniciAdi.isDisplayed());

//      9. 'Oturumu Kapat' butonuna tıklayın
        driver.findElement(By.xpath("//a[@href=\"/logout\"]")).click();

//      10. Kullanıcının giriş sayfasına yönlendirildiğini doğrulayın
        String expecedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expecedUrl,actualUrl);


    }
}
