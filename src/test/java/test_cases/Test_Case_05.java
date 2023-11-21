package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case_05 extends TestBase {


//  TEST SENARYOSU 5: Kullanıcıyı mevcut e-postayla kaydedin


    @Test
    public void test01() throws InterruptedException {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";
        Assert.assertEquals(expecedTitle,actualTitle);


//      4.  'Kayıt Ol / Giriş Yap' butonuna tıklayın
        driver.findElement(By.xpath("//a[@href='/login']")).click();      // 2.yol


//      5.  'Yeni Kullanıcı Kaydı!' seçeneğinin görünür olduğunu doğrulayın
        WebElement yeniKullaniciKaydi = driver.findElement(By.xpath("(//h2)[3]"));
        Assert.assertTrue(yeniKullaniciKaydi.isDisplayed());


//      6.   Adı ve kayıtlı e-posta adresini girin
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Ali Özcan");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("kardeslerime.selam.571@gmail.com");


//      7.  'Kayıt Ol' butonuna tıklayın
        Thread.sleep(1500);
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();


//      8. 'E-posta Adresi zaten mevcut!' hatasının görünür olduğunu doğrulayın
        WebElement message = driver.findElement(By.xpath("//p[@style=\"color: red;\"]"));
        String expecedMessage = "Email Address already exist!";
        String actualMessage = message.getText();
        Assert.assertEquals(expecedMessage,actualMessage);



    }
}
