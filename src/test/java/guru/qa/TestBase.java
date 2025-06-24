package guru.qa;

import com.codeborne.selenide.Configuration;
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
        } );
    }
}