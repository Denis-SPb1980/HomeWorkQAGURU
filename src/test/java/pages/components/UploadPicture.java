package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class UploadPicture {
    private final SelenideElement uploadPicture = $("#uploadPicture");

    public void uploadPicture (String classpath) {
        uploadPicture.uploadFromClasspath(classpath);
    }
}