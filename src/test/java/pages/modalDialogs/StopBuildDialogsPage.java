package pages.modalDialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class StopBuildDialogsPage {
    protected final SelenideElement
            window = $("#stopBuildFormDialog"),
            stopButton = window.$(".submitButton");
}
