package test_cases;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Test_Case_11 extends TestBase {


//     TEST CASE 11: Verify Subscription in Cart page

    @Test
    public void test01() {

//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
//        3. Verify that home page is visible successfully
        String actualTitle = driver.getTitle();
        String expecedTitle = "Automation Exercise";
        Assert.assertEquals(expecedTitle, actualTitle);


//        4. Click 'Cart' button
        driver.findElement(By.xpath("(//a[@href=\"/view_cart\"])[1]")).click();


//        5. Scroll down to footer
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();


//        6. Verify text 'SUBSCRIPTION'
        String subscriptionText = driver.findElement(By.xpath("//*[.=\"Subscription\"]")).getText();
        Assert.assertEquals("SUBSCRIPTION", subscriptionText);


//        7. Enter email address in input and click arrow button
        driver.findElement(By.xpath("//input[@id=\"susbscribe_email\"]")).
                sendKeys(faker.internet().emailAddress(), Keys.ENTER);


//        8. Verify success message 'You have been successfully subscribed!' is visible
        String text = driver.findElement(By.xpath("//*[.=\"You have been successfully subscribed!\"]")).getText();
        Assert.assertEquals("You have been successfully subscribed!",text);



    }
}
