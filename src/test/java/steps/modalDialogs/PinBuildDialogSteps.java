package steps.modalDialogs;

import pages.modalDialogs.PinBuildDialogPage;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class PinBuildDialogSteps extends PinBuildDialogPage {

    public PinBuildDialogSteps setPinMessage(String message) {
        step("Enter pin message - " + message, () -> {
            pinMessageInput.setValue(message);
        });
        return this;
    }

    public PinBuildDialogSteps clickPinButton() {
        step("Click on Pin button", () -> {
            window.should(appear);
            window.shouldHave(text("Pin Build"));
            pinButton.click();
            window.should(disappear);
        });
        return this;
    }
}
