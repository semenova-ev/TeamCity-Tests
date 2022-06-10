package pages.modalDialogs;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SnapshotDependencyDialogPage {
    protected final SelenideElement
            window = $("#sourceDependenciesDialog"),
            windowHeader = window.$(".dialogHeader"),
            projectsTree = $(".ProjectsTree__list--K_"),
            saveButton = window.$(".submitButton");
}
