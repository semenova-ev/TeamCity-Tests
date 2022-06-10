package steps.modalDialogs;

import pages.modalDialogs.ReRunBuildDialogPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class ReRunBuildDialogSteps extends ReRunBuildDialogPage {

    public ReRunBuildDialogSteps clickRunButton() {
        step("Click on Run button", () -> {
            window.should(appear, Duration.ofSeconds(30));
            window.shouldHave(text("Run Custom Build"));
            runButton.click();
            window.should(disappear);
        });
        return this;
    }
}
