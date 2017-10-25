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
public class InsureTravelerRegistration extends BasePage{

    private String insured_surname, insured_name, insured_birthDate, surname, name, middlename,
            birthDate, passport_series, passport_number, issueDate, issuePlace, checrInsured_birthDate, checkBirthDate, checkIssueDate;

    private void loadPersonalDataFromProperties() {
        Properties properties = TestProperties.getInstanse().getProperties();
        insured_surname = properties.getProperty("insured_surname");
        insured_name = properties.getProperty("insured_name");
        insured_birthDate = properties.getProperty("insured_birthDate");
        surname = properties.getProperty("surname");
        name = properties.getProperty("name");
        middlename = properties.getProperty("middlename");
        birthDate = properties.getProperty("birthDate");
        passport_series = properties.getProperty("passport_series");
        passport_number = properties.getProperty("passport_number");
        issueDate = properties.getProperty("issueDate");
        issuePlace = properties.getProperty("issuePlace");
        checkIssueDate = properties.getProperty("checkIssueDate");
        checkBirthDate = properties.getProperty("checkBirthDate");
        checrInsured_birthDate = properties.getProperty("checrInsured_birthDate");

    }

    @FindBy(name = "insured0_surname")
    private WebElement insuredSurnameInput;

    @FindBy(name = "insured0_name")
    private WebElement insuredNameInput;

    @FindBy(name = "insured0_birthDate")
    private WebElement insuredBirthDateInput;

    @FindBy(name = "surname")
    private WebElement surenameInput;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "middlename")
    private WebElement middlenameInput;

    @FindBy(name = "birthDate")
    private WebElement birthDateInput;

    @FindBy(name = "passport_series")
    private WebElement passportSeriesInput;

    @FindBy(name = "passport_number")
    private WebElement passportNumberInput;

    @FindBy(name = "issueDate")
    private WebElement issueDateInput;

    @FindBy(name = "issuePlace")
    private WebElement issuePlaceInput;

    public InsureTravelerRegistration(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        loadPersonalDataFromProperties();
    }

    public InsureTravelerRegistration fill() {
        fillField(insuredSurnameInput, insured_surname);
        fillField(insuredNameInput, insured_name);
        fillField(insuredBirthDateInput, insured_birthDate);
        fillField(surenameInput, surname);
        fillField(nameInput, name);
        fillField(middlenameInput, middlename);
        birthDateInput.click();
        fillField(birthDateInput, birthDate);
        fillField(passportNumberInput, passport_number);
        fillField(passportSeriesInput, passport_series);
        fillField(issueDateInput, issueDate);
        fillField(issuePlaceInput, issuePlace);
        return this;
    }
    public InsureTravelerRegistration check() {
        checkFieldText(insuredSurnameInput, insured_surname);
        checkFieldText(insuredNameInput, insured_name);
        checkFieldText(insuredBirthDateInput, checrInsured_birthDate);
        checkFieldText(surenameInput, surname);
        checkFieldText(nameInput, name);
        checkFieldText(middlenameInput, middlename);
        checkFieldText(birthDateInput, checkBirthDate);
        checkFieldText(passportNumberInput, passport_number);
        checkFieldText(passportSeriesInput, passport_series);
        checkFieldText(issueDateInput, checkIssueDate);
        checkFieldText(issuePlaceInput, issuePlace);
        return this;
    }
}
