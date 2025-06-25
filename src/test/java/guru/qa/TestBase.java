package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static io.qameta.allure.Allure.step;

public class TestBase {
    @BeforeAll
    static void setUp() {
        step("Открытие страницы", () -> {
            String selenoidHost = System.getProperty("selenoid_host",  "selenoid.autotests.cloud");
            String selenoidLogin = System.getProperty("selenoid_login", "user1");
            String selenoidPassword = System.getProperty("selenoid_password", "1234");
            String browser = System.getProperty("browser", "chrome");
            String browserVersion = System.getProperty("browserVersion", "127.0");
            String screenResolution = System.getProperty("screenResolution", "1920x1080");

            Configuration.browserSize = screenResolution;
            Configuration.baseUrl = "https://demoqa.com";
            Configuration.pageLoadStrategy = "eager";
            Configuration.remote = String.format("https://%s:%s@%s/wd/hub", selenoidLogin, selenoidPassword, selenoidHost);
            Configuration.browser = browser;
            Configuration.browserVersion = browserVersion;

            SelenideLogger.addListener("allure", new AllureSelenide());

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        } );
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshots");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}