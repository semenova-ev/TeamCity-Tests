package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class BuildPage {
    // locators
    protected final SelenideElement
            tabsTitles = $(".ring-tabs-titles"),
            artifactsTab = tabsTitles.$(By.linkText("Artifacts")),
            artifactDownloadButton = $(".OverviewTab__limitedWidth--lF").$(byTagName("a")),
            pinnedInfoBlock = $(".BuildOverviewTab__secondInfoGroup--p1"),
            tagsInfoBlock = $(".TagsList__wrapper--tx");

}
