package steps;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import pages.BuildConfigConfigurationPage;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class BuildConfigConfigurationSteps extends BuildConfigConfigurationPage {

    public BuildConfigConfigurationSteps clickRunButton() {
        step("Click on Run button", () -> {
            runButton.shouldBe(Condition.visible, Duration.ofSeconds(30));
            runButton.click();
        });
        return this;
    }

    public BuildConfigConfigurationSteps showMoreGeneralSettings() {
        step("Click on Show more general settings link if there is one", () -> {
            if (showMoreGeneralSettingsButton.is(Condition.exist)) {
                showMoreGeneralSettingsButton.click();
            }
        });
        return this;
    }

    public BuildConfigConfigurationSteps clickDependenciesMenuItem() {
        step("Click on Dependencies menu item", () -> {
            dependenciesMenuItem.should(Condition.exist, Duration.ofMinutes(1));
            dependenciesMenuItem.click();
        });
        return this;
    }

    public BuildConfigConfigurationSteps clickTriggersMenuItem() {
        step("Click on Triggers menu item", () -> {
            triggersMenuItem.should(Condition.exist, Duration.ofMinutes(1));
            triggersMenuItem.click();
        });
        return this;
    }

    public BuildConfigConfigurationSteps clickAddNewSnapshotDependencyButton() {
        step("Click on Add new snapshot dependency button", () -> {
            addNewSnapshotDependencyButton.should(Condition.exist, Duration.ofMinutes(1));
            addNewSnapshotDependencyButton.click();
        });
        return this;
    }

    public BuildConfigConfigurationSteps clickAddNewArtifactDependencyButton() {
        step("Click on Add new artifact dependency button", () -> {
            addNewArtifactDependencyButton.should(Condition.exist, Duration.ofMinutes(1));
            addNewArtifactDependencyButton.click();
        });
        return this;
    }

    public BuildConfigConfigurationSteps clickAddNewTriggerButton() {
        step("Click on Add new trigger button", () -> {
            addNewTriggerButton.should(Condition.exist, Duration.ofMinutes(1));
            addNewTriggerButton.click();
        });
        return this;
    }

    public BuildConfigConfigurationSteps snapshotDependenciesShouldBeUpdated(String dependency) {
        step("Checking if snapshot dependency was updated", () -> {
            snapshotDependenciesUpdatedMessage.shouldBe(Condition.visible, Duration.ofMinutes(1));
            snapshotDependenciesTable.$(By.linkText(dependency)).should(Condition.exist);
        });
        return this;
    }

    public BuildConfigConfigurationSteps artifactDependenciesShouldBeUpdated(String dependency) {
        step("Checking if artifact dependency was updated", () -> {
            artifactDependenciesUpdateMessage.shouldBe(Condition.visible, Duration.ofMinutes(1));
            artifactDependenciesTable.$(By.linkText(dependency)).should(Condition.exist);
        });
        return this;
    }

    public BuildConfigConfigurationSteps triggersShouldBeUpdated(String trigger) {
        step("Checking if trigger was updated", () -> {
            buildTriggerMessage.shouldBe(Condition.visible, Duration.ofMinutes(1));
            triggersTable.shouldHave(Condition.text(trigger));
        });
        return this;
    }
}
