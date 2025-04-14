package lesson1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    public void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }

    @Test
    public void yaSuccessfulSearchTest() {
        open("https://ya.ru/");
        $("[name=text]").setValue("selenide").pressEnter();
        $("[id=search-result]").shouldHave(text("selenide.org"));
    }
}
