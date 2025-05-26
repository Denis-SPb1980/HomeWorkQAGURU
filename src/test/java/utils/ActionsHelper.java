package utils;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ActionsHelper {

    public void removeFixedElements() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}