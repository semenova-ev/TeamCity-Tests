package steps.modalDialogs;

import pages.modalDialogs.AddTagsDialogPage;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class AddTagsDialogSteps extends AddTagsDialogPage {

    public AddTagsDialogSteps setTag(String tag) {
        step("Add tag " + tag, () -> {
            window.should(appear);
            window.shouldHave(text("Add Build Tags"));
            addTagsInput.setValue(tag);
            addTagConfirmButton.click();
        });
        return this;
    }

    public AddTagsDialogSteps clickSaveButton() {
        step("Click on Save button", () -> {
            saveButton.click();
            window.should(disappear);
        });
        return this;
    }
}
