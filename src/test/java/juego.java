import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;
public class juego {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Zephyrus\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.thetestingworld.com/shop/index.php";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testUmstcs() throws Exception {
        driver.get("https://www.juegosjuegos.com/jugar-juego/red-ball-5.html");
       // WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"term\"]"));
       // searchBox.sendKeys("mario");
      //  searchBox.sendKeys(Keys.ENTER);
       // driver.findElement(By.xpath("//*[@id=\"GamesFilterGames\"]/ul/li[15]/a")).click();
        //Thread.sleep(10000);
        //WebElement MarioGame = driver.findElement(By.xpath("//*[@id=\"canvas\"]"));
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"gameContainer\"]/div/div[2]/button/i")).click();
        Thread.sleep(3000);
        Actions actions=new Actions(driver);
        actions.moveByOffset(721,410).click();
        actions.moveByOffset(721,410).click();
        Thread.sleep(10000);

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

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
