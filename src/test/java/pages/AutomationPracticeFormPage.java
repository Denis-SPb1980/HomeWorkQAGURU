package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.UploadPicture;
import utils.ActionsHelper;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement genderRadioButton = $("#genterWrapper");
    private final SelenideElement phoneNumberInput = $("#userNumber");
    private final SelenideElement dateOfBirth = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesCheckBox = $("#hobbiesWrapper");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement stateSelect = $("#state");
    private final SelenideElement stateSelectInput = $("#react-select-3-input");
    private final SelenideElement citySelect = $("#react-select-3-input");
    private final SelenideElement citySelectInput = $("#react-select-4-input");
    private final SelenideElement submitButton = $("#submit");
    private final ElementsCollection checkResult = $$("table tr");
    private final SelenideElement formSubmitted = $("#example-modal-sizes-title-lg");
    private final SelenideElement modal = $(".modal-content");

    CalendarComponent calendarComponent = new CalendarComponent();
    ActionsHelper actionsHelper = new ActionsHelper();
    UploadPicture uploadPicture = new UploadPicture();

    public AutomationPracticeFormPage openPage() {
        open("/automation-practice-form");
        actionsHelper.removeFixedElements();
        return this;
    }

    public AutomationPracticeFormPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public AutomationPracticeFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public AutomationPracticeFormPage setGender(String value) {
        genderRadioButton.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setPhoneNumber(String phoneNumber) {
        phoneNumberInput.setValue(phoneNumber);
        return this;
    }

    public AutomationPracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirth.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public AutomationPracticeFormPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public AutomationPracticeFormPage setHobbies(String hobbies) {
        hobbiesCheckBox.$(byText(hobbies)).click();
        return this;
    }

    public AutomationPracticeFormPage uploadProfile(String classpath) {
        uploadPicture.uploadPicture(classpath);
        return this;
    }

    public AutomationPracticeFormPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public AutomationPracticeFormPage setState(String state) {
        stateSelect.click();
        stateSelectInput.setValue(state).pressEnter();
        return this;
    }

    public AutomationPracticeFormPage setCity(String city) {
        citySelect.click();
        citySelectInput.setValue(city).pressEnter();
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public void checkResult(String key, String value) {
        checkResult.findBy(text(key)).shouldHave(text(value));
    }

    public void verifyFormSubmittedSuccessfully(){
        formSubmitted.shouldHave(text("Thanks for submitting the form"));
    }

    public void checkUnsubmitedForm(){
        modal.shouldNotBe(visible);
    }
}