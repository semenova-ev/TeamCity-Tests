package steps;

import pages.AdministrationPage;

import static io.qameta.allure.Allure.step;

public class AdministrationSteps extends AdministrationPage {

    public AdministrationSteps clickCreateProjectButton() {
        step("Click on Create project button", () -> {
            createProjectButton.click();
        });
        return this;
    }
}
