import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestingWorld {
    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Zephyrus\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.thetestingworld.com/shop/index.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Test
    public void testUmstcs() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/div/div/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div/div[2]/div[2]/button[1]/i")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"cart-total\"]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li[2]/div/p/a[2]/strong")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"collapse-checkout-option\"]/div/div/div[1]/div[2]/label/input")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"button-account\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"input-payment-firstname\"]")).sendKeys("testbuyer");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"input-payment-lastname\"]")).sendKeys("testbuyerlastname");
        Thread.sleep(1000);
                driver.findElement(By.cssSelector("#input-payment-email")).sendKeys("testbuyer@mailinator.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"input-payment-telephone\"]")).sendKeys("45698522");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"input-payment-address-1\"]")).sendKeys("teststreet 123");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"input-payment-city\"]")).sendKeys("cochabamba");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"input-payment-postcode\"]")).sendKeys("45615");
                Select country = new Select( driver.findElement(By.xpath("//*[@id=\"input-payment-country\"]")));
        country.selectByValue("26");
        Thread.sleep(1000);
        Select region = new Select (driver.findElement(By.xpath("//*[@id=\"input-payment-zone\"]")));
        region.selectByValue("405");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"button-guest\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#button-shipping-method")).click();
        Thread.sleep(2000);
        WebElement checkbox = driver.findElement(By.cssSelector("#collapse-payment-method > div > div.buttons > div > input[type=checkbox]:nth-child(2)"));
           checkbox.click();
        driver.findElement(By.cssSelector("#button-payment-method")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#button-confirm")).click();
        Thread.sleep(5000);
        String succesMessage = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
        System.out.println(succesMessage);
    }
    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
