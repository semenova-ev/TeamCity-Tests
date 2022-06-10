package steps;

import com.codeborne.selenide.Condition;
import pages.CreateProjectPage;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class CreateProjectSteps extends CreateProjectPage {

    public CreateProjectSteps clickFromRepositoryURL() {
        step("Click on From repository URL button", () -> {
            fromRepositoryURLButton.click();
        });
        return this;
    }

    public CreateProjectSteps setParentProject(String parentProject) {
        step("Choose parent project as " + parentProject, () -> {
            parentProjectInput.setValue(parentProject);
        });
        return this;
    }

    public CreateProjectSteps setRepositoryURL(String url) {
        step("Enter repository URL " + url, () -> {
            repositoryURL.setValue(url);
        });
        return this;
    }

    public CreateProjectSteps clickProceedButton() {
        step("Click on Proceed button", () -> {
            proceedButton.shouldBe(Condition.visible, Duration.ofSeconds(10));
            proceedButton.click();
        });
        return this;
    }
}
