package steps.modalDialogs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import pages.modalDialogs.ArtifactDependencyDialogPage;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.by;
import static io.qameta.allure.Allure.step;

public class ArtifactDependencyDialogSteps extends ArtifactDependencyDialogPage {

    public ArtifactDependencyDialogSteps clickSelectBuildConfigButton() {
        step("Click on Select build configuration button", () -> {
            selectBuildConfigButton.should(Condition.exist, Duration.ofSeconds(20));
            selectBuildConfigButton.click();
        });
        return this;
    }

    public ArtifactDependencyDialogSteps selectBuildConfiguration(String project, String buildConfig) {
        step("Select build configuration " + buildConfig + " from project " + project, () -> {
            artifactFromArea.shouldBe(Condition.visible, Duration.ofSeconds(30));
            artifactFromArea.$(by("id", Configuration.baseUrl + "_search_project_" + project)).click();
            artifactFromArea.$(by("id", Configuration.baseUrl + "_search_buildType_" + project + "_" + buildConfig)).shouldBe(Condition.visible, Duration.ofSeconds(30)).click();
        });
        return this;
    }

    public ArtifactDependencyDialogSteps setArtifactRules(String rules) {
        step("Enter artifact rules", () -> {
            artifactRules.setValue(rules);
        });
        return this;
    }

    public ArtifactDependencyDialogSteps clickSaveButton() {
        step("Click on Save button", () -> {
            saveButton.shouldBe(Condition.visible, Duration.ofSeconds(30));
            saveButton.click();
        });
        return this;
    }
}
