package guru.qa;

import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;
import utils.TestData;

public class PracticeFormTests extends TestBase{
    AutomationPracticeFormPage registrationPage = new AutomationPracticeFormPage();
    TestData testData = new TestData();

    @Test
    public void fillRegistrationFormTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubjects(testData.subject)
                .setHobbies(testData.hobby)
                .uploadProfile(testData.picture)
                .setCurrentAddress(testData.currentAddress)
                .setState(testData.state)
                .setCity(testData.city).clickSubmit();

        registrationPage.verifyFormSubmittedSuccessfully();
        registrationPage.checkResult("Student Name", testData.firstName +" "+ testData.lastName);
        registrationPage.checkResult("Student Email", testData.email);
        registrationPage.checkResult("Gender", testData.gender);
        registrationPage.checkResult("Mobile", testData.phoneNumber);
        registrationPage.checkResult("Date of Birth", testData.dayOfBirth +" "+ testData.monthOfBirth +","+ testData.yearOfBirth);
        registrationPage.checkResult("Subjects", testData.subject);
        registrationPage.checkResult("Hobbies", testData.hobby);
        registrationPage.checkResult("Picture", testData.picture);
        registrationPage.checkResult("Address", testData.currentAddress);
        registrationPage.checkResult("State and City",  testData.state +" "+ testData.city);
    }

    @Test
    public void fillRegistrationShortFormTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .clickSubmit();

        registrationPage.verifyFormSubmittedSuccessfully();
        registrationPage.checkResult("Student Name", testData.firstName +" "+ testData.lastName);
        registrationPage.checkResult("Gender", testData.gender);
        registrationPage.checkResult("Mobile", testData.phoneNumber);
    }

    @Test
    public void registrationFormInvalidPhoneNumberTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setPhoneNumber("8999").clickSubmit();

        registrationPage.checkUnsubmitedForm();
    }
}