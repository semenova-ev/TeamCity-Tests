package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class BuildConfigConfigurationPage {
    protected final SelenideElement
            runButton = $(by("data-hint-container-id", "build-configuration-admin-run-button"))
            .$(by("class", "btn btn_mini runFirstBuild")),
            leftMenuBlock = $("#buildTypeTabsContainer"),
            showMoreGeneralSettingsButton = leftMenuBlock.$(By.linkText("Show more »")),
            hideUnconfiguredButton = leftMenuBlock.$(By.linkText("« Hide unconfigured")),
            dependenciesMenuItem = leftMenuBlock.$(By.linkText("Dependencies")),
            triggersMenuItem = leftMenuBlock.$(By.linkText("Triggers")),
            mainContentBlock = $("#main-content-tag"),
            addNewSnapshotDependencyButton = mainContentBlock.$(By.linkText("Add new snapshot dependency")),
            addNewArtifactDependencyButton = mainContentBlock.$(By.linkText("Add new artifact dependency")),
            addNewTriggerButton = mainContentBlock.$(By.linkText("Add new trigger")),
            snapshotDependenciesUpdatedMessage = $("#unprocessed_dependenciesUpdated"),
            artifactDependenciesUpdateMessage = $("#unprocessed_artifactDependenciesUpdated"),
            buildTriggerMessage = $("#unprocessed_buildTriggersUpdated"),
            snapshotDependenciesTable = $("#snapshotDeps"),
            artifactDependenciesTable = $("#artifactDeps"),
            triggersTable = $("#buildTriggersTable");

}
