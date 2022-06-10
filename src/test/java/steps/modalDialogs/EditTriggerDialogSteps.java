package steps.modalDialogs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import pages.modalDialogs.EditTriggerDialogPage;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class EditTriggerDialogSteps extends EditTriggerDialogPage {

    public EditTriggerDialogSteps selectTrigger(String trigger) {
        step("Select " + trigger + " trigger", () -> {
            triggerComboBox.should(Condition.exist, Duration.ofSeconds(20));
            $(".-ufd-teamcity-ui-triggerNameSelector").click();
            $(".list-wrapper-ufd-teamcity-ui-triggerNameSelector").$(by("data-title",trigger)).click();
        });
        return this;
    }

    public EditTriggerDialogSteps showAdvancedOptions() {
        step("Click on Show advanced options link if there is one", () -> {
            Selenide.sleep(2000);
            if (showAdvancedOptionsButton.is(Condition.exist)) {
                showAdvancedOptionsButton.click();
            }
        });
        return this;
    }

    public EditTriggerDialogSteps checkTriggerBuildOnChangesCheck() {
        step("Select Build on changes checkbox", () -> {
            triggerBuildOnChangesCheck.should(Condition.exist, Duration.ofSeconds(30));
            triggerBuildOnChangesCheck.setSelected(true);
        });
        return this;
    }

    public EditTriggerDialogSteps clickSaveButton() {
        step("Click on Save button", () -> {
            saveButton.shouldBe(Condition.visible, Duration.ofSeconds(30));
            saveButton.click();
        });
        return this;
    }
}
