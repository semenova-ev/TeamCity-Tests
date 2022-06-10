package tests;

import api.BuildConfigAPI;
import api.ProjectAPI;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import steps.*;
import testData.MainTestConfiguration;
import testData.Users;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class QuickStartTests extends MainTestConfiguration {
    final String SOURCE_PROJECT_NAME = "BuildActionsProject";
    final String SOURCE_BUILD_ID = "BuildActionsProject_BuildEmpty";
    final String NEW_BUILD_NAME = "Build";
    final String NEW_BUILD_ID = "BuildActionsProject_Build";

    TeamCityUISteps teamCityUISteps = new TeamCityUISteps();
    ProjectSteps projectSteps = new ProjectSteps();
    BuildConfigSteps buildConfigSteps = new BuildConfigSteps();
    AdministrationSteps administrationSteps = new AdministrationSteps();
    CreateProjectSteps createProjectSteps = new CreateProjectSteps();
    CreateProjectFromURLSteps createProjectFromURLSteps = new CreateProjectFromURLSteps();
    BuildConfigConfigurationSteps buildConfigConfigurationSteps = new BuildConfigConfigurationSteps();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        configure();
    }

    @Test
    void authorizationWithUserNamePass() {

        String currentLocation = Configuration.baseUrl + "/favorite/projects";
        step("Check for current location is " + currentLocation, () -> {
            webdriver().shouldHave(url(currentLocation));
        });
    }

    @Test
    void createProjectTest() {
        final String projectName = "FirstProject";
        final String projectId = "FirstProject";
        final String repositoryURL = "https://github.com/semenova-ev/FirstProject";

        ProjectAPI createdProject = new ProjectAPI(Users.mainUsertoken);
        createdProject.deleteProject(projectId);

        teamCityUISteps
                .openAdministration();
        administrationSteps
                .clickCreateProjectButton();
        createProjectSteps
                .clickFromRepositoryURL()
                .setParentProject("<Root project>")
                .setRepositoryURL(repositoryURL)
                .clickProceedButton();
        createProjectFromURLSteps
                .clickProceedButton()
                .checkMaven()
                .clickUseSelectedButton();
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(projectName);
        projectSteps
                .openBuild("Build");


        createdProject.deleteProject(projectId);
    }

    @Test
    void runBuildFromBuildConfPage() {
        BuildConfigAPI bc = new BuildConfigAPI(getUserToken());

        // copy BC
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID);

        // do UI
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(SOURCE_PROJECT_NAME);
        projectSteps
                .openBuild(NEW_BUILD_NAME);
        buildConfigSteps
                .clickEditConfigurationButton();
        buildConfigConfigurationSteps
                .clickRunButton();
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(SOURCE_PROJECT_NAME);
        projectSteps
                .openBuild(NEW_BUILD_NAME);
        buildConfigSteps
                .showQueue()
                .shouldHaveStatusPassed();

        // delete BC
        bc.deleteBuildConfiguration();
    }
}
