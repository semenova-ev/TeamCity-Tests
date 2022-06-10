package steps.modalDialogs;

import pages.modalDialogs.StopBuildDialogsPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class StopBuildDialogsSteps extends StopBuildDialogsPage {

    public StopBuildDialogsSteps clickStopButton() {
        step("Click on Stop button", () -> {
            window.should(appear);
            window.shouldHave(text("Stop build"));
            stopButton.click();
            window.should(disappear);
        });
        return this;
    }
}
