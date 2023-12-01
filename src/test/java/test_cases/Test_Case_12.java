package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case_12 extends TestBase {


//      TEST CASE 12: Add Products in Cart

    @Test
    public void test01() throws InterruptedException {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";
        Assert.assertEquals(expecedTitle, actualTitle);


//        4. Click 'Products' button
        driver.findElement(By.xpath("//a[@href=\"/products\"]")).click();


//        5. Hover over first product and click 'Add to cart'
        WebElement img1 = driver.findElement(By.xpath("//img[@src=\"/get_product_picture/1\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(img1).perform();
        Thread.sleep(1000);
        WebElement button = driver.findElement(By.xpath("(//a[@data-product-id=\"1\"])[2]"));
        actions.click(button).perform();


//        6. Click 'Continue Shopping' button
        Thread.sleep(1000);
        WebElement button1 = driver.findElement(By.xpath("//*[.=\"Continue Shopping\"]"));
        actions.click(button1).perform();


//        7. Hover over second product and click 'Add to cart'
        WebElement img2 = driver.findElement(By.xpath("//img[@src=\"/get_product_picture/2\"]"));
        actions.moveToElement(img2).perform();
        Thread.sleep(1000);
        WebElement button2 = driver.findElement(By.xpath("(//a[@data-product-id=\"2\"])[2]"));
        actions.click(button2).perform();


//        8. Click 'View Cart' button
        driver.findElement(By.xpath("//u[.=\"View Cart\"]")).click();


//        9. Verify both products are added to Cart
        WebElement product1 = driver.findElement(By.xpath("//tr[@id=\"product-1\"]"));
        WebElement product2 = driver.findElement(By.xpath("//tr[@id=\"product-2\"]"));
        Assert.assertTrue(product1.isDisplayed());
        Assert.assertTrue(product2.isDisplayed());


//        10. Verify their prices, quantity and total price
        WebElement price1 = driver.findElement(By.xpath("(//td[@class=\"cart_price\"])[1]"));
        WebElement price2 = driver.findElement(By.xpath("(//td[@class=\"cart_price\"])[2]"));
        WebElement quantity1 = driver.findElement(By.xpath("(//td[@class=\"cart_quantity\"])[1]"));
        WebElement quantity2 = driver.findElement(By.xpath("(//td[@class=\"cart_quantity\"])[2]"));
        WebElement total1 = driver.findElement(By.xpath("(//td[@class=\"cart_total\"])[1]"));
        WebElement total2 = driver.findElement(By.xpath("(//td[@class=\"cart_total\"])[2]"));

        Assert.assertEquals("Rs. 500",price1.getText());
        Assert.assertEquals("Rs. 400",price2.getText());
        Assert.assertEquals("1",quantity1.getText());
        Assert.assertEquals("1",quantity2.getText());
        Assert.assertEquals("Rs. 500",total1.getText());
        Assert.assertEquals("Rs. 400",total2.getText());



    }
}
