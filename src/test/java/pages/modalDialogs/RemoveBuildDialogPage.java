package pages.modalDialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RemoveBuildDialogPage {
    protected final SelenideElement
            window = $("#stopBuildFormDialog"),
            removeButton = window.$(".submitButton");
}
