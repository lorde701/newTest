package ru.qa.autotest.rule;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import ru.qa.autotest.TestProperties;

import java.io.IOException;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

public class SberRule extends ExternalResource{

    private WebDriver driver;
    public static Properties properties = TestProperties.getInstanse().getProperties();
    private static String baseUrl = "";

    public void before() throws IOException {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriver.chrome.driver"));
        //System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "drv/IEDriverServer.exe");
        //driver = new InternetExplorerDriver();

        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        baseUrl = properties.getProperty("app.url");

        driver.get(baseUrl);
    }

    public void after() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
