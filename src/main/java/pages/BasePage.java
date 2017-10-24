package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by Иванка on 24.10.2017.
 */
public abstract class BasePage {
    WebDriver driver;

    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void checkFieldText(WebElement element, String text) {
        String expectedText = element.getText();
        if (expectedText.equals("")){
            expectedText = element.getAttribute("value");
        }
        assertEquals(expectedText, text);
    }

    public void waitElementVisibility(WebElement element, long timeOutInSec, long sleepInMillis) {
        Wait<WebDriver> wait = new WebDriverWait(driver, timeOutInSec, sleepInMillis);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
