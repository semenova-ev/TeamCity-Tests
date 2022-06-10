package steps;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import pages.BuildConfigPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class BuildConfigSteps extends BuildConfigPage {

    public BuildConfigSteps runBuild() {
        step("Click Run build button", () -> {
            runBuildButton.$(by("data-test", "run-build")).click();
        });
        return this;
    }

    public BuildConfigSteps shouldHaveStatusPassed() {
        step("Check if build has status Passed", () -> {
            buildStatus.$(By.ByPartialLinkText.linkText("Tests passed: 1")).should(exist, Duration.ofMinutes(5));
        });
        return this;
    }

    public BuildConfigSteps shouldHaveStatusSuccess() {
        step("Check if build has status Success", () -> {
            buildStatus.$(By.ByPartialLinkText.linkText("Success")).should(exist, Duration.ofMinutes(10));
        });
        return this;
    }

    public BuildConfigSteps shouldHaveSecondBuild() {
        step("Check if there is second build", () -> {
            buildsContainer.shouldHave(text("#2"), Duration.ofSeconds(60));
        });
        return this;
    }

    public BuildConfigSteps shouldHaveStatusCancel() {
        step("Check if build has status Canceled", () -> {
            buildStatus.$(By.ByPartialLinkText.linkText("Canceled")).should(exist, Duration.ofMinutes(5));
        });
        return this;
    }

    public BuildConfigSteps showBuildInfo() {
        buildStatus.click();
        return this;
    }

    public BuildConfigSteps openBuildDropDownMenu() {
        step("Click on build menu (...)", () -> {
            //Selenide.sleep(3000);
            buildLoading.shouldNot(exist, Duration.ofMinutes(1));
            dropDownMenuButton.click();
        });
        return this;
    }

    public BuildConfigSteps shouldHaveNoBuilds() {
        step("Check if there are no builds", () -> {
            warningsBlock.shouldHave(text("No builds found in whole build history"));
        });
        return this;
    }

    public BuildConfigSteps shouldBeInFavorites() {
        step("Check if there is Favorite icon", () -> {
            favoritesOffFastButton.shouldNot(exist);
        });
        return this;
    }

    public BuildConfigSteps showQueue() {
        step("Click on show build link if there is one", () -> {
            if (buildsPlaceHolder.has(text("Show 1 build"))) {
                buildsPlaceHolder.$(By.partialLinkText("Show 1 build")).click();
            }
        });
        return this;
    }

    public BuildConfigSteps stopBuild() {
        step("Click on Stop build button", () -> {
            stopBuildFastButton.should(exist, Duration.ofSeconds(60));
            stopBuildFastButton.click();
        });
        return this;
    }

    public BuildConfigSteps clickEditConfigurationButton() {
        step("Click on Edit configuration button", () -> {
            editConfigurationButton.click();
        });
        return this;
    }

    public BuildConfigSteps clickDeployButton() {
        step("Click on Deploy button", () -> {
            deployButton.shouldBe(visible, Duration.ofSeconds(30));
            deployButton.click();
        });
        return this;
    }
}
