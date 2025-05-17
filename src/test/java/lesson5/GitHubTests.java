package lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTests {
    String expectedCode = """
                The AI-powered
                developer platform
               """;
    @BeforeAll
    static void setUp() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void solutionsHoverTest() {
        open("https://github.com/");
        $(byTagAndText("button","Solutions")).hover();
        $(byTagAndText("a","Enterprises")).click();

        $("#hero-section-brand-heading").shouldHave(exactText(expectedCode));
    }
}