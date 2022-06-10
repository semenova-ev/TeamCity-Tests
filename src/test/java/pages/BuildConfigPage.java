package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;

public class BuildConfigPage {
    protected final SelenideElement
            runBuildButton = $(".BuildTypePageHeader__links--TF"),
            dropDownMenuButton = $(".Builds__hasParentGrid--fI").$(".ActionsDropdown__anchorButton--eT"),
            buildStatus =  $(".Build__status--bG"),
            buildLoading = $(by("data-test-icon", "running_green")),
            buildsPlaceHolder = $("Builds__placeholder--NM"),
            warningsBlock = $(".PagerWarning__warning--My"),
            favoritesOffFastButton = $(".BuildDetails__heading--o4").$(".StarBuild__invisible--gP"),
            stopBuildFastButton = $(".Build__stop--VP"),
            editConfigurationButton = $(".BuildTypePageHeader__links--TF").$(By.linkText("Edit configuration...")),
            deployButton = $(".BuildTypePageHeader__links--TF").$(by("title", "Deploy")),
            buildsContainer = $(".BuildDetails__buildContainer--Ez");

}
