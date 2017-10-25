package ru.qa.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.qa.autotest.TestProperties;

import java.util.Properties;

/**
 * Created by Иванка on 24.10.2017.
 */
public class InsureTraveler extends BasePage{
    private String lable;

    //private final String LABLE = "Страхование путешественников";

    @FindBy(xpath = "//H1[text()='Страхование путешественников']")
    private WebElement insureTravelerLbl;

    @FindBy(xpath = "//IMG[@src='/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53']")
    private WebElement formOnlineImg;

    private void loadDataFromProperties() {
        Properties properties = TestProperties.getInstanse().getProperties();
        lable = properties.get("insureTraveler.label").toString();
    }

    public InsureTraveler(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        //loadDataFromProperties();
    }

    public InsureTravelerChoicePolis openInsureTravelerChoicePolis(String checkLabel) {
        checkFieldText(insureTravelerLbl, checkLabel);
        insureTravelerLbl.click();

        switchToNewWindowOnClick(formOnlineImg, 10);
        //formOnlineImg.click();

        return new InsureTravelerChoicePolis(driver);
    }

}
