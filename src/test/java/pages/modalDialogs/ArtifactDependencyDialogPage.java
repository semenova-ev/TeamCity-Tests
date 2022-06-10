package pages.modalDialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class ArtifactDependencyDialogPage {
    protected final SelenideElement
            window = $("#artifactDependencyFormDialog"),
            windowHeader = window.$(".dialogHeader"),
            selectBuildConfigButton = window.$("#buildTypeSelector").$(by("type","button")),
            artifactFromArea = $(".ReactVirtualized__Grid__innerScrollContainer"),
            artifactRules = window.$("#artifactPaths"),
            saveButton = window.$(".submitButton");
}
