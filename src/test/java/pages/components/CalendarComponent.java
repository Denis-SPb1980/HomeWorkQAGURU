package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {
    private final ElementsCollection calendarDaySelect = $$("div.react-datepicker__day");
    private final SelenideElement calendarMonthSelect = $(".react-datepicker__month-select");
    private final SelenideElement calendarYearSelect = $(".react-datepicker__year-select");

    public void setDate(String day, String month, String year) {
        calendarMonthSelect.selectOption(month);
        calendarYearSelect.selectOption(year);
        calendarDaySelect.findBy(text(day)).click();
    }
}