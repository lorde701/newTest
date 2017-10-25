package ru.qa.autotest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Иванка on 24.10.2017.
 */
public class MainPage extends BasePage {
    @FindBy(xpath = "//span[contains(text(),'Застраховать себя')]")
    private WebElement insureBtn;

    @FindBy(xpath = "//a[contains(@class,'kit-link kit-link_color_black alt-menu-list__link alt-menu-list__link_level_1') and text() = 'Страхование путешественников']")
    private WebElement insureTraveler;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public static MainPage onMainPage(WebDriver driver) {
        return new MainPage(driver);
    }

    public InsureTraveler openInsureTraveler() {
        //waitElementVisibility(insureBtn, 5, 1000);
        insureBtn.click();
        waitElementVisibility(insureTraveler, 5, 1000);
        insureTraveler.click();
        return new InsureTraveler(driver);
    }
}
