import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.qa.autotest.pages.MainPage;
import ru.qa.autotest.rule.SberRule;

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

        MainPage.onMainPage(driver)
                .openInsureTraveler()
                .openInsureTravelerChoicePolis("Страхование путешественников")
                .openInsureTravelerRegistration()
                .fillDate()
                .checkDate();

    }

}
