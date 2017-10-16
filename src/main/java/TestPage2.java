import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
public class TestPage2 {

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
    public void fillForm() throws Exception{

        String fn = "firstname"; String ln = "lastname";

        Helper helper = new Helper(driver, "http://toolsqa.com/automation-practice-form/");
        helper.goToWeb();

        if(helper.isPresent(fn))
            helper.setName("Vratislav", fn);
        if(helper.isPresent(ln))
            helper.setName("Holub", ln);

        if(helper.isPresent("sex"))
            helper.setSex("sex-0");

        if(helper.isPresent("continents"))
            helper.setContinent("continents");

        if(helper.isPresent("submit"))
            helper.submitForm("submit");

    }
}
