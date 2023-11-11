package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class Test_Case_03 extends TestBase {


//   TEST SENARYOSU 3: Kullanıcının yanlış e-posta adresi ve şifreyle oturum açması



    @Test
    public void test01() {

//      3. Ana sayfanın başarıyla göründüğünü doğrulayın
        Assert.assertEquals("Automation Exercise",driver.getTitle());


//      4. 'Kayıt Ol / Giriş Yap' butonuna tıklayın
        driver.findElement(By.xpath("//a[@href='/login']")).click();


//      5. 'Hesabınıza giriş yapın' seçeneğinin görünür olduğunu doğrulayın
        WebElement hesabinizaGirisYapin = driver.findElement(By.xpath("(//h2)[1]"));
        Assert.assertTrue(hesabinizaGirisYapin.isDisplayed());


//      6. Yanlış e-posta adresi ve şifreyi girin
        driver.findElement(By.xpath("//input[@data-qa=\"login-email\"]")).sendKeys("selam.571@gmail.com");
        driver.findElement(By.xpath("//input[@data-qa=\"login-password\"]")).sendKeys("123456789");


//      7. 'Giriş yap' düğmesine tıklayın
        driver.findElement(By.xpath("//button[@data-qa=\"login-button\"]")).click();


//      8. 'E-postanız veya şifreniz yanlış!' hatasını görünür olduğunu doğrulayın
        WebElement actualMessage = driver.findElement(By.xpath("//p[@style=\"color: red;\"]"));
        //driver.findElement(By.xpath("//*[.=\"Your email or password is incorrect!\"]"));
        //driver.findElement(By.xpath("//*[contains(text(),'Your email')]"));

        Assert.assertTrue(actualMessage.isDisplayed());


    }





}







