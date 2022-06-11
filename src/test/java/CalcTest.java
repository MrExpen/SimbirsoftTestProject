import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CalcTest {

    private static final String CHROME_DRIVER_LOCATION = "chromedriver.exe";
    private static final Duration IMPLICITLY_WAIT_DURATION = Duration.ofSeconds(10);
    private static final String GOOGLE_URL = "https://google.com";

    private static CalcPage calcPage;

    public static WebDriver driver;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(IMPLICITLY_WAIT_DURATION);
    }

    @AfterAll
    public static void cleanUp() {
        driver.quit();
    }

    @BeforeEach
    public void initCalcPage(){
        driver.get(GOOGLE_URL);
        SearchPage searchPage = new SearchPage(driver);
        calcPage = searchPage.searchCalc();
    }

    @Test
    public void testCase1(){
        calcPage.setExpression("(1 + 2) * 3 - 40 / 5");
        calcPage.clickButtonCalc();
        Assertions.assertEquals("(1 + 2) × 3 - 40 ÷ 5 =", calcPage.getMemoryValue());
        Assertions.assertEquals("1", calcPage.getResultValue());
    }

    @Test
    public void testCase2(){
        calcPage.setExpression("6/0");
        calcPage.clickButtonCalc();
        Assertions.assertEquals("6 ÷ 0 =", calcPage.getMemoryValue());
        Assertions.assertEquals("Infinity", calcPage.getResultValue());
    }

    @Test
    public void testCase3(){
        calcPage.clickButtonSin();
        calcPage.clickButtonCalc();
        Assertions.assertEquals("sin() =", calcPage.getMemoryValue());
        Assertions.assertEquals("Error", calcPage.getResultValue());
    }
}
