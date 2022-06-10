package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class ProjectPage {
    // locators
    protected final SelenideElement
            overviewTab = $(".OverviewTab__limitedWidth--lF"),
            showAllConfigurationsButton = $(".ShowAllBuildTypes__button--HF"),
            buildChainsTab = $(".ring-tabs-autoCollapseContainer").$(By.linkText("Build Chains")),
            deployChainStatus = $("#allChainsInner");
}
