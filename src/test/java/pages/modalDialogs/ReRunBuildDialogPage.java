package pages.modalDialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ReRunBuildDialogPage {
    protected final SelenideElement
            window = $("#runBuildDialog"),
            runButton = window.$(".submitButton");
}
