package utilities;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {


    protected static WebDriver driver;
    protected static Faker faker;


    @BeforeClass
    public static void beforeClass() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        faker = new Faker();

    }



    @Before
    public void setUp() throws Exception {
        driver.get("http://automationexercise.com");
    }




    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        //driver.close();
    }


    @AfterClass
    public static void afterClass() throws Exception {
        Thread.sleep(2000);
        driver.quit();
    }
}
