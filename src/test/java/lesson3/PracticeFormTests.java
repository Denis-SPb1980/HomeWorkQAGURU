package lesson3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void fillRegistrationFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Test");
        $("#lastName").setValue("Testov");
        $("#userEmail").setValue("test@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("8999000131");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1993");
        $$("div.react-datepicker__day").findBy(text("15")).click();
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("picture.jpg");
        $("#currentAddress").setValue("Test Address");
        $("#state").click();
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#city").click();
        $("#react-select-4-input").setValue("Delhi").pressEnter();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $$("table tr").findBy(text("Student Name")).shouldHave(text("Test Testov"));
        $$("table tr").findBy(text("Student Email")).shouldHave(text("test@mail.ru"));
        $$("table tr").findBy(text("Gender")).shouldHave(text("Male"));
        $$("table tr").findBy(text("Mobile")).shouldHave(text("8999000131"));
        $$("table tr").findBy(text("Date of Birth")).shouldHave(text("15 May,1993"));
        $$("table tr").findBy(text("Subjects")).shouldHave(text("Computer Science"));
        $$("table tr").findBy(text("Hobbies")).shouldHave(text("Sports"));
        $$("table tr").findBy(text("Picture")).shouldHave(text("picture.jpg"));
        $$("table tr").findBy(text("Address")).shouldHave(text("Test Address"));
        $$("table tr").findBy(text("State and City")).shouldHave(text("NCR Delhi"));
    }
}