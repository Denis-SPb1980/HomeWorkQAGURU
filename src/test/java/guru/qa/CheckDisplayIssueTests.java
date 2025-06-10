package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.AllureWebSteps;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class CheckDisplayIssueTests {

    @BeforeEach
    void connectAllure() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    String REPOSITORY = "allure-framework/allure2";
    AllureWebSteps steps = new AllureWebSteps();

    @Test
    public void selenideTest(){

        open("https://github.com");
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        $("[href='/allure-framework/allure2']").click();
        $("#issues-tab").click();

        $(byText("New issue"));
    }

    @Test
    public void lambdaTest(){

        step("Открытие главной страницы", () -> {
            open("https://github.com");
        } );

        step("Поиск репозитория", () -> {
            $("[data-target='qbsearch-input.inputButtonText']").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        } );

        step("Клик по найденному репозиторию", () -> {
            $("[href='/allure-framework/allure2']").click();
        } );

        step("Открыть Issues", () -> {
            $("#issues-tab").click();
        } );

        step("Проверить наличие кнопки 'New Issue'", () -> {
            $(byText("New issue"));
        } );
    }

    @Test
    public void stepsTest(){

       steps.openPage();
       steps.searchForRepository(REPOSITORY);
       steps.clickOnFoundRepository();
       steps.openIssues();
       steps.checkButtonPresence();
    }
}