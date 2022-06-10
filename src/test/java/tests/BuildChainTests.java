package tests;

import api.ProjectAPI;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import steps.*;
import steps.modalDialogs.ArtifactDependencyDialogSteps;
import steps.modalDialogs.EditTriggerDialogSteps;
import steps.modalDialogs.SnapshotDependencyDialogSteps;
import testData.MainTestConfiguration;
import testData.Users;

public class BuildChainTests extends MainTestConfiguration {
    final String NEW_PROJECT_NAME = "Pipeline";
    final String NEW_PROJECT_ID = "Pipeline";
    final String SOURCE_PROJECT_ID = "PipelineEmpty";
    final String SOURCE_FULL_PROJECT_ID = "PipelineFull";

    TeamCityUISteps teamCityUISteps = new TeamCityUISteps();
    ProjectSteps projectSteps = new ProjectSteps();
    BuildConfigSteps buildConfigSteps = new BuildConfigSteps();
    AdministrationSteps administrationSteps = new AdministrationSteps();
    CreateProjectSteps createProjectSteps = new CreateProjectSteps();
    CreateProjectFromURLSteps createProjectFromURLSteps = new CreateProjectFromURLSteps();
    BuildConfigConfigurationSteps buildConfigConfigurationSteps = new BuildConfigConfigurationSteps();
    ArtifactDependencyDialogSteps addNewArtifactDependencyDialogSteps = new ArtifactDependencyDialogSteps();
    SnapshotDependencyDialogSteps snapshotDependencyDialogSteps = new SnapshotDependencyDialogSteps();
    EditTriggerDialogSteps editTriggerDialogSteps = new EditTriggerDialogSteps();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        configure();
    }

//    @Test
//    void clear() {
//        ProjectAPI project = new ProjectAPI(Users.mainUsertoken);
//        project.deleteProject("Pipeline");
//        //project.deleteProject("Pipeline1");
//    }

    @Test
    void createBuildChainProjectTest() {
        final String projectName = "Pipeline";
        final String projectId = "Pipeline";
        final String repositoryURL = "https://github.com/semenova-ev/Pipeline";

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
                .clickProceedButton();
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(projectName);
        projectSteps
                .shouldHaveBuild("App")
                .shouldHaveBuild("Test")
                .shouldHaveBuild("TestReport")
                .shouldHaveBuild("Deploy");

        createdProject.deleteProject(projectId);
    }

    @Test
    void configureSnapshotDependencyTest() {
        ProjectAPI createdProject = new ProjectAPI(Users.mainUsertoken);
        createdProject.copyProject("", NEW_PROJECT_NAME, NEW_PROJECT_ID, SOURCE_PROJECT_ID);

        teamCityUISteps
                .openFavoriteProjects()
                .openProject(NEW_PROJECT_NAME);
        projectSteps
                .openBuild("TestReport");
        buildConfigSteps
                .clickEditConfigurationButton();
        buildConfigConfigurationSteps
                .showMoreGeneralSettings()
                .clickDependenciesMenuItem()
                .clickAddNewSnapshotDependencyButton();
        snapshotDependencyDialogSteps
                .addNewSnapshotDependencyShouldAppear()
                .selectDependency(NEW_PROJECT_NAME, "Test")
                .clickSaveButton();
        buildConfigConfigurationSteps
                .snapshotDependenciesShouldBeUpdated("Test");

        createdProject.deleteProject();
    }

    @Test
    void configureArtifactDependencyTest() {
        ProjectAPI createdProject = new ProjectAPI(Users.mainUsertoken);
        createdProject.copyProject("", NEW_PROJECT_NAME, NEW_PROJECT_ID, SOURCE_PROJECT_ID);

        teamCityUISteps
                .openFavoriteProjects()
                .openProject(NEW_PROJECT_NAME);
        projectSteps
                .openBuild("Deploy");
        buildConfigSteps
                .clickEditConfigurationButton();
        buildConfigConfigurationSteps
                .showMoreGeneralSettings()
                .clickDependenciesMenuItem()
                .clickAddNewArtifactDependencyButton();
        addNewArtifactDependencyDialogSteps
                .clickSelectBuildConfigButton()
                .selectBuildConfiguration(NEW_PROJECT_NAME, "App")
                .setArtifactRules("app.jar => build/libs/app.jar")
                .clickSaveButton();
        buildConfigConfigurationSteps
                .artifactDependenciesShouldBeUpdated("App");

        createdProject.deleteProject();
    }

    @Test
    void addVCSTriggerTest() {
        ProjectAPI createdProject = new ProjectAPI(Users.mainUsertoken);
        createdProject.copyProject("", NEW_PROJECT_NAME, NEW_PROJECT_ID, SOURCE_PROJECT_ID);

        teamCityUISteps
                .openFavoriteProjects()
                .openProject(NEW_PROJECT_NAME);
        projectSteps
                .openBuild("Deploy");
        buildConfigSteps
                .clickEditConfigurationButton();
        buildConfigConfigurationSteps
                .showMoreGeneralSettings()
                .clickTriggersMenuItem()
                .clickAddNewTriggerButton();
        editTriggerDialogSteps
                .selectTrigger("VCS Trigger")
                .showAdvancedOptions()
                .checkTriggerBuildOnChangesCheck()
                .clickSaveButton();
        buildConfigConfigurationSteps
                .triggersShouldBeUpdated("VCS Trigger");

        createdProject.deleteProject();
    }

    @Test
    void manuallyRunSimpleChainTest() {
        ProjectAPI createdProject = new ProjectAPI(Users.mainUsertoken);
        createdProject.copyProject("", NEW_PROJECT_NAME, NEW_PROJECT_ID, SOURCE_FULL_PROJECT_ID);

        teamCityUISteps
                .openFavoriteProjects()
                .openProject(NEW_PROJECT_NAME);
        projectSteps
                .openBuild("Deploy");
        buildConfigSteps
                .clickDeployButton()
                .shouldHaveStatusSuccess();

        createdProject.deleteProject();
    }
}
