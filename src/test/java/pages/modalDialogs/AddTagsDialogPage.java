package pages.modalDialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class AddTagsDialogPage {
    protected final SelenideElement
            window = $(".ring-dialog-innerContainer"),
            addTagsInput = window.$(".ring-input-input"),
            addTagConfirmButton = $(by("data-test", "ring-select-toolbar-button")),
            saveButton = window.$(".ring-button-primary");
}
