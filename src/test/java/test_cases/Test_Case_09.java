package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Test_Case_09 extends TestBase {


//        TEST CASE 9: Search Product


    @Test
    public void test01() {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";
        Assert.assertEquals(expecedTitle,actualTitle);


//        4. Click on 'Products' button
        driver.findElement(By.xpath("//i[@class=\"material-icons card_travel\"]")).click();


//        5. Verify user is navigated to ALL PRODUCTS page successfully
        String pageTitle1 = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]")).getText();
        Assert.assertEquals("ALL PRODUCTS",pageTitle1);

//        6. Enter product name in search input and click search button
        driver.findElement(By.xpath("//input[@id=\"search_product\"]")).
                                    sendKeys("jeans",Keys.TAB, Keys.ENTER);

//        7. Verify 'SEARCHED PRODUCTS' is visible
        String pageTitle2 = driver.findElement(By.xpath("//h2[@class=\"title text-center\"]")).getText();
        Assert.assertEquals("SEARCHED PRODUCTS",pageTitle2);



//        8. Verify all the products related to search are visible
        WebElement product1 = driver.findElement(By.xpath("(//img[@alt=\"ecommerce website products\"])[1]"));
        WebElement product2 = driver.findElement(By.xpath("(//img[@alt=\"ecommerce website products\"])[2]"));
        WebElement product3 = driver.findElement(By.xpath("(//img[@alt=\"ecommerce website products\"])[3]"));

        Assert.assertTrue(product1.isDisplayed() && product2.isDisplayed() && product3.isDisplayed());


    }
}
