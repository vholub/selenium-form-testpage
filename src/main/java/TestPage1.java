import com.google.common.util.concurrent.AbstractScheduledService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestPage1 {

    private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void openingSeznam() {
        Helper helper = new Helper(driver, "http://www.seznam.cz");

        // method from helper that will go to the site entered into helper
        // constructor
        helper.goToWeb();
    }

}
