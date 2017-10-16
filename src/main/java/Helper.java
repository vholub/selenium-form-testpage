import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Vráťa H., this class is supposed to contain methods that are executing
 *         behavior on web pages (for e.g. clicking buttons)
 */
public class Helper {
    private final WebDriver driver;
    private final String baseURL;

    public Helper(WebDriverFactory driverFactory, String baseURL) {
        this.driver = driverFactory.getDriver();
        this.baseURL = baseURL;
    }

    // constructor
    public Helper(WebDriver driver, String baseURL) {
        this.driver = driver;
        this.baseURL = baseURL;
    }

    // method for opening web page
    public void goToWeb() {
        driver.get(this.baseURL);
    }

    // method for changing name in form & verifying it
    public void setName(String Name, String tagName){
        WebElement nickname = driver.findElement(By.name(tagName));
        nickname.sendKeys(Name);

        String value = driver.findElement(By.name(tagName)).getAttribute(("value"));
        System.out.println(value);
    }
    // method for changing sex in form
    public void setSex(String sexID){
        WebElement radioButton = driver.findElement(By.id(sexID));
        radioButton.click();
    }
    //method for changing continent from drop-down menu
    public void setContinent(String continentID){
        Select dropdown = new Select(driver.findElement(By.id(continentID)));
        dropdown.selectByVisibleText("Europe");
    }

    // method for submit form
    public void submitForm(String formID){
        WebElement btn = driver.findElement(By.id(formID));
        btn.click();
    }

    //method for verifying if element is present
    public boolean isPresent(String elementName){
        try {
            driver.findElement(By.name(elementName)).isDisplayed();
            System.out.println("Element has been found.");
            return true;
        }
        catch(NoSuchElementException e){
            System.out.println("Error, element has not been found." + e.getMessage());
            return false;
        }
    }
}



