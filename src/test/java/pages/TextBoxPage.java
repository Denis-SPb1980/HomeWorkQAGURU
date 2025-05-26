package pages;

import com.codeborne.selenide.SelenideElement;
import utils.ActionsHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    private final SelenideElement fullNameInput = $("#userName");
    private final SelenideElement emailInput = $("#userEmail");
    private final SelenideElement currentAddressInput = $("#currentAddress");
    private final SelenideElement permanentAddressInput = $("#permanentAddress");
    private final SelenideElement submitButton = $("#submit");
    private final SelenideElement fullNameOutput = $("#name");
    private final SelenideElement emailOutput = $("#email");
    private final SelenideElement currentAddressOutput = $("#output #currentAddress");
    private final SelenideElement permanentAddressOutput = $("#output #permanentAddress");


    ActionsHelper actionsHelper = new ActionsHelper();

    public TextBoxPage openPage() {
        open("/text-box");
        actionsHelper.removeFixedElements();
        return this;
    }

    public TextBoxPage setFullName(String fullName) {
        fullNameInput.setValue(fullName);
        return this;
    }

    public TextBoxPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public TextBoxPage setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public TextBoxPage setPermanentAddress(String permanentAddress) {
        permanentAddressInput.setValue(permanentAddress);
        return this;
    }

    public void clickSubmit() {
        submitButton.click();
    }

    public TextBoxPage checkFullName (String value) {
        fullNameOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkEmail (String value) {
        emailOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkCurrentAddress (String value) {
        currentAddressOutput.shouldHave(text(value));
        return this;
    }

    public TextBoxPage checkPermanentAddress (String value) {
        permanentAddressOutput.shouldHave(text(value));
        return this;
    }
}