package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import pages.TeamCityUIPage;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class TeamCityUISteps extends TeamCityUIPage {

    public TeamCityUISteps openFavoriteProjects() {
        step("Open projects page", () -> {
            headerPortal.shouldBe(Condition.visible, Duration.ofMinutes(2));
            projectsMenuButton.click();
        });
        return this;
    }

    public TeamCityUISteps openAdministration() {
        step("Open Administration page", () -> {
            administrationMenuButton.click();
        });
        return this;
    }

    public TeamCityUISteps openProject(String projectName) {
        step("Open project " + projectName, () -> {
            projectsTree.shouldBe(Condition.visible, Duration.ofMinutes(2));
            projectsTree.$(By.linkText(projectName)).click();
        });
        return this;
    }
}
