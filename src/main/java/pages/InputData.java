package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Иванка on 24.10.2017.
 */
public class InputData extends BasePage{

    private final String LASTNAME = "Petrov";

    @FindBy(name = "insured0_surname")
    private WebElement nameIn;

    public InputData(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public InputData fill() {
        fillField(nameIn,LASTNAME);
        return this;
    }
    public InputData check() {
        checkFieldText(nameIn, LASTNAME);
        return this;
    }
}
