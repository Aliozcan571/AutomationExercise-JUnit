package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Test_Case_07 extends TestBase {


//  TEST CASE 7: Verify Test Cases Page


    @Test
    public void test01() {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";
        Assert.assertEquals(expecedTitle,actualTitle);


//      4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//a[@href=\"/test_cases\"]")).click();
        driver.navigate().refresh();
        driver.findElement(By.xpath("//a[@href=\"/test_cases\"]")).click();


//      5. Verify user is navigated to test cases page successfully
        String expectedUrl = "https://automationexercise.com/test_cases";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);





//



    }
}
