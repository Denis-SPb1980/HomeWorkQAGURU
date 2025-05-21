package guru.qa;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;

public class PracticeFormTests extends TestBase{
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

    @Test
    public void fillRegistrationShortFormTest() {
        registrationPage.openPage().setFirstName("Test").setLastName("Testov").setGender("Female")
                .setPhoneNumber("8999000131").clickSubmit();

        registrationPage.verifyFormSubmittedSuccessfully();
        registrationPage.checkResult("Student Name", "Test Testov");
        registrationPage.checkResult("Gender", "Female");
        registrationPage.checkResult("Mobile", "8999000131");
    }

    @Test
    public void registrationFormInvalidPhoneNumberTest() {
        registrationPage.openPage().setFirstName("Test").setLastName("Testov").setGender("Female")
                .setPhoneNumber("8999").clickSubmit();

        registrationPage.checkUnsubmitedForm();
    }
}