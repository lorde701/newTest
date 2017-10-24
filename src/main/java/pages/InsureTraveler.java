package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Иванка on 24.10.2017.
 */
public class InsureTraveler extends BasePage{

    private final String LABLE = "Страхование путешественников";

    @FindBy(xpath = "//H1[text()='Страхование путешественников']")
    private WebElement insureTravelerLbl;

    @FindBy(xpath = "//IMG[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']")
    private WebElement formOnlineImg;

    public InsureTraveler(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SelectAmount openSelectAmount() {
        checkFieldText(insureTravelerLbl, LABLE);
        insureTravelerLbl.click();
        formOnlineImg.click();
        return new SelectAmount(driver);
    }

}
