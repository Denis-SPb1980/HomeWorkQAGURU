package guru.qa;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxTest extends TestBase{
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    public void fillFormTest(){
        textBoxPage.openPage().setFullName("Testov Test Testovich").setEmail("test@test.ru").setCurrentAddress("current address")
                .setPermanentAddress("permanent address").clickSubmit();

        textBoxPage.checkFullName("Testov Test Testovich").checkEmail("test@test.ru")
                .checkCurrentAddress("current address").checkPermanentAddress("permanent address");
    }
}