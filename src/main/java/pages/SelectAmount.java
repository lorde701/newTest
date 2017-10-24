package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Иванка on 24.10.2017.
 */
public class SelectAmount extends BasePage{
    @FindBy(xpath = "//DIV[text()='Необходимый минимум для оплаты медицинской помощи за границей']")
    private WebElement minimumDiv;

    @FindBy(xpath = "//SPAN[text()='Оформить']")
    private WebElement formBtn;

    @FindBy(xpath = "//H1[text()='Страхование путешественников']")
    private WebElement insureTravelerLbl;

    public SelectAmount(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public InputData openInputData() {
        checkFieldText(insureTravelerLbl, "Страхование путешественников"); // это поле из предыдущего окна
        minimumDiv.click();                                                     // эта кнопка из текущего окна, тут тест падает, получается, что он не переходит в новое окно автоматически
        formBtn.click();
        return new InputData(driver);
    }

}
