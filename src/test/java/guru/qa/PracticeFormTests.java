package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;

public class PracticeFormTests {
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    AutomationPracticeFormPage registrationPage = new AutomationPracticeFormPage();

    @Test
    public void fillRegistrationFormTest() {
        registrationPage.openPage().setFirstName("Test").setLastName("Testov").setEmail("test@mail.ru").setGender("Male")
                        .setPhoneNumber("8999000131").setDateOfBirth("15", "May", "1993").setSubjects("Computer Science")
                        .setHobbies("Sports").uploadProfile("picture.jpg").setCurrentAddress("Test Address")
                        .setState("NCR").setCity("Delhi").clickSubmit();

        registrationPage.verifyFormSubmittedSuccessfully();
        registrationPage.checkResult("Student Name", "Test Testov");
        registrationPage.checkResult("Student Email", "test@mail.ru");
        registrationPage.checkResult("Gender", "Male");
        registrationPage.checkResult("Mobile", "8999000131");
        registrationPage.checkResult("Date of Birth", "15 May,1993");
        registrationPage.checkResult("Subjects", "Computer Science");
        registrationPage.checkResult("Hobbies", "Sports");
        registrationPage.checkResult("Picture", "picture.jpg");
        registrationPage.checkResult("Address", "Test Address");
        registrationPage.checkResult("State and City", "NCR Delhi");
    }
}