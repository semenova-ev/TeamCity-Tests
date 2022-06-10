package steps.modalDialogs;

import pages.modalDialogs.RemoveBuildDialogPage;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class RemoveBuildDialogSteps extends RemoveBuildDialogPage {

    public RemoveBuildDialogSteps clickRemoveButton() {
        step("Click on Remove button", () -> {
            window.should(appear);
            window.shouldHave(text("Remove build"));
            removeButton.click();
            window.should(disappear);
        });
        return this;
    }
}
