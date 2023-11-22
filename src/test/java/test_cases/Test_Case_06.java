package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;

public class Test_Case_06 extends TestBase {


//  TEST SENARYOSU 6: Bize Ulaşın Formu


    @Test
    public void test01() throws InterruptedException {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";
        Assert.assertEquals(expecedTitle,actualTitle);


//      4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()= ' Contact us']")).click();


//      5. 'İRTİBATA GEÇİN' seçeneğinin göründüğünü doğrulayın
        WebElement option = driver.findElement(By.xpath("//*[text()= 'Get In Touch']"));
        Assert.assertTrue(option.isDisplayed());


//      6. Adı, e-postayı, konuyu ve mesajı girin
        driver.findElement(By.xpath("//input[@name=\"name\"]")).sendKeys("Ali Özcan");
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("kardeslerime.selam.571@gmail.com");
        driver.findElement(By.xpath("//input[@name=\"subject\"]")).sendKeys("Ürün Çeşitliliği");
        driver.findElement(By.xpath("//textarea[@id=\"message\"]")).sendKeys("Ürün çeşitliliği şu an için biraz sınırlı gibi görünüyor. Belki de kategorilerde ve markalarda daha geniş bir yelpaze sunabilirsiniz.");


//      7. Dosyayı yükleyin
        WebElement dosyasec = driver.findElement(By.xpath("//input[@type=\"file\"]"));
        String yol = "C:\\Users\\Ali\\IdeaProjects\\Automation-Exercise\\src\\test\\java\\utilities\\Dosya001.png";
        dosyasec.sendKeys(yol);

//      8. 'Gönder' düğmesini tıklayın
        Thread.sleep(1500);
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

//      9. Tamam düğmesine tıklayın
        Thread.sleep(1500);
        driver.switchTo().alert().accept();


//      10. 'Başarılı! Bilgileriniz başarıyla gönderildi.' mesajının göründüğünü doğrulayın
        WebElement message = driver.findElement(By.xpath("//div[@class=\"status alert alert-success\"]"));
        Assert.assertTrue(message.isDisplayed());


//      11. 'Ana Sayfa' butonuna tıklayın ve ana sayfaya başarıyla ulaşıldığını doğrulayın
        WebElement button = driver.findElement(By.xpath("//a[@class=\"btn btn-success\"]"));
        button.click();

        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        button.click();

        String expecedUrl = "https://automationexercise.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expecedUrl,actualUrl);





    }

}
