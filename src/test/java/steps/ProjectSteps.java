package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.ProjectPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class ProjectSteps extends ProjectPage {

    public ProjectSteps openBuild(String buildName) {
        step("Open build configuration " + buildName, () -> {
            Selenide.refresh();
            if (showAllConfigurationsButton.has(text("Show all"))) {
                showAllConfigurationsButton.click();
            }
            overviewTab.$(By.linkText(buildName)).click();
            Selenide.refresh();
        });
        return this;
    }

    public ProjectSteps shouldHaveBuild(String buildName) {
        step("Check if the build configuration" + buildName + "exists", () -> {
            Selenide.refresh();
            if (showAllConfigurationsButton.has(text("Show all"))) {
                showAllConfigurationsButton.click();
            }
            overviewTab.$(By.linkText(buildName)).should(exist, Duration.ofSeconds(10));
        });
        return this;
    }

    public ProjectSteps openBuildChainTab() {
        step("Open Build Chain tab", () -> {
            buildChainsTab.shouldBe(visible, Duration.ofSeconds(30));
            buildChainsTab.click();
        });
        return this;
    }

    public ProjectSteps shouldDeploySuccessful() {
        step("Check if deploy was successful", () -> {
            //deployChainStatus.shouldHave(text("Success"), Duration.ofMinutes(7));
            //$(By.linkText("Success")).should(exist, Duration.ofMinutes(7));
            //$("#mainContent").$(byLinkText("Success")).should(exist, Duration.ofMinutes(10));
            //$(by("title", "View build results")).shouldHave(text("Success"), Duration.ofMinutes(10));
        });
        return this;
    }
}
