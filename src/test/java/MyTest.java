import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import rule.SberRule;

/**
 * Created by Иванка on 24.10.2017.
 */
public class MyTest {
    private WebDriver driver;

    @Rule
    public SberRule rule = new SberRule();

    @Test
    public void test() throws Exception {
        WebDriver driver = rule.getDriver();

        MainPage mainPage = new MainPage(driver);
        mainPage.onMainPage(driver)
                .openInsureTraveler()
                .openSelectAmount()
                .openInputData()
                .fill()
                .check();

    }

}
