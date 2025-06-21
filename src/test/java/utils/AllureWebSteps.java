package utils;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AllureWebSteps {

    @Step("Открыть главную страницу")
    public void openPage(){
        open("https://github.com");
    }

    @Step("Поиск репозитория")
    public void searchForRepository(String repository){
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue(repository).pressEnter();
    }

    @Step("Клик по найденному репозиторию")
    public void clickOnFoundRepository(){
        $("[href='/allure-framework/allure2']").click();
    }

    @Step("Открыть Issues")
    public void openIssues(){
        $("#issues-tab").click();
    }

    @Step("Проверка наличия кнопки 'New Issue'\"")
    public void checkButtonPresence(){
        $(byText("New issue"));
    }
}