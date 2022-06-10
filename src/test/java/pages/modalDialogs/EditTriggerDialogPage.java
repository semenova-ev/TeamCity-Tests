package pages.modalDialogs;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EditTriggerDialogPage {
    protected final SelenideElement
            window = $("#editTriggerDialog"),
            windowHeader = window.$(".dialogHeader"),
            triggerComboBox = window.$("#-ufd-teamcity-ui-triggerNameSelector"),
            showAdvancedOptionsButton = window.$(By.linkText("Show advanced options")),
            triggerBuildOnChangesCheck = window.$("#watchChangesInDependencies"),
            saveButton = window.$("#editTriggerSubmit");


}
