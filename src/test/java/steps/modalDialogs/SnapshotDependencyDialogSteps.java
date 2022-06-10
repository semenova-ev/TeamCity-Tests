package steps.modalDialogs;

import com.codeborne.selenide.Configuration;
import pages.modalDialogs.SnapshotDependencyDialogPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static io.qameta.allure.Allure.step;

public class SnapshotDependencyDialogSteps extends SnapshotDependencyDialogPage {

    public SnapshotDependencyDialogSteps addNewSnapshotDependencyShouldAppear() {
        step("Checking if Add new snapshot dependency modal window is appear", () -> {
            window.should(appear, Duration.ofSeconds(30));
            windowHeader.shouldHave(text("Add New Snapshot Dependency"));
        });
        return this;
    }

    public SnapshotDependencyDialogSteps selectDependency(String projectName, String buildConfig) {
        step("Select build configuration " + buildConfig + " from " + projectName + " project", () -> {
            projectsTree.$(by("id", Configuration.baseUrl + "_search_buildType_Pipeline_Test")).click();
        });
        return this;
    }

    public SnapshotDependencyDialogSteps clickSaveButton() {
        step("Click on Save button", () -> {
            saveButton.click();
        });
        return this;
    }
}
