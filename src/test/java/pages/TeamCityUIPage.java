package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class TeamCityUIPage {
    // locators
    protected final SelenideElement
            headerPortal = $("#topWrapper"),
            //headerPortal = $("#react-header-container"),
            projectsMenuButton = headerPortal.$(By.linkText("Projects")),
            administrationMenuButton = headerPortal.$(By.linkText("Administration")),
            //unpinButton = $(".Builds__hasParentGrid--fI").$(by("title", "Unpin...")),
            projectsTree = $(".ReactVirtualized__Grid__innerScrollContainer");
}
