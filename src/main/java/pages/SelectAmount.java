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

    public SelectAmount(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public InputData openInputData() {
        minimumDiv.click();
        formBtn.click();
        return new InputData(driver);
    }

}
