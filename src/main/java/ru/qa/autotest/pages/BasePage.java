package ru.qa.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

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

    public void switchToNewWindowOnClick(WebElement element, long timeOutInSec) {
        final Set<String> oldWindowsSet = driver.getWindowHandles();
        element.click();
        String newWindowHandle = (new WebDriverWait(driver, timeOutInSec))
                .until(new ExpectedCondition<String>() {
                           public String apply(WebDriver driver) {
                               Set<String> newWindowsSet = driver.getWindowHandles();
                               newWindowsSet.removeAll(oldWindowsSet);
                               return newWindowsSet.size() > 0 ?
                                       newWindowsSet.iterator().next() : null;
                           }
                       }
                );
        driver.switchTo().window(newWindowHandle);
    }
}
