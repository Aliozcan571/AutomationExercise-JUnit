package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case_08 extends TestBase {

//        TEST CASE 8: Verify All Products and product detail page

    @Test
    public void test01() {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";
        Assert.assertEquals(expecedTitle,actualTitle);


//        4. Click on 'Products' button
        driver.findElement(By.xpath("//a[@href=\"/products\"]")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href=\"/products\"]")).click();


//        5. Verify user is navigated to ALL PRODUCTS page successfully
        String actualUrl = driver.getCurrentUrl();
        String expecedUrl = "https://automationexercise.com/products";
        Assert.assertEquals(expecedUrl,actualUrl);


//        6. Verify that the 'ALL PRODUCTS' heading appears
        String actualTitle1 = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]")).getText();
        String expectedTitle1 = "ALL PRODUCTS";
        Assert.assertEquals(expectedTitle1, actualTitle1);


//        7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//ul[@class=\"nav nav-pills nav-justified\"])[1]")).click();


//        8. User is landed to product detail page
        String actualUrl1 = driver.getCurrentUrl();
        String expecedUrl1 = "https://automationexercise.com/product_details/1";
        Assert.assertEquals(expecedUrl1,actualUrl1);


//        9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//*[text()=\"Blue Top\"]"));
        WebElement category = driver.findElement(By.xpath("//*[text()=\"Category: Women > Tops\"]"));
        WebElement price = driver.findElement(By.xpath("//*[text()=\"Rs. 500\"]"));
        WebElement availability = driver.findElement(By.xpath("//*[text()=\" In Stock\"]"));
        WebElement condition = driver.findElement(By.xpath("//*[text()=\" New\"]"));
        WebElement brand = driver.findElement(By.xpath("//*[text()=\" Polo\"]"));


        Assert.assertTrue(productName.isDisplayed());
        Assert.assertTrue(category.isDisplayed());
        Assert.assertTrue(price.isDisplayed());
        Assert.assertTrue(availability.isDisplayed());
        Assert.assertTrue(condition.isDisplayed());
        Assert.assertTrue(brand.isDisplayed());



    }
}
