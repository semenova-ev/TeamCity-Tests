package pages.modalDialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PinBuildDialogPage {
    protected final SelenideElement
            window = $(".ring-dialog-innerContainer"),
            pinMessageInput = window.$(".ring-input-input"),
            pinButton = window.$(".ring-button-primary");
}
