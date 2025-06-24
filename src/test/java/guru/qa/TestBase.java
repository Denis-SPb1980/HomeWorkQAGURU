package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    static void setUp() {
        step("Открытие страницы", () -> {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager";
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
            SelenideLogger.addListener("allure", new AllureSelenide());
        } );
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshots");
    }
}