package tests;

import api.BuildConfigAPI;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import steps.*;
import steps.modalDialogs.*;
import testData.MainTestConfiguration;

import java.io.IOException;
import java.net.URISyntaxException;

import static io.qameta.allure.Allure.step;

public class MainActionsOnBuildTests extends MainTestConfiguration {
    final String SOURCE_PROJECT_NAME = "BuildActionsProject";
    final String SOURCE_BUILD_ID = "BuildActionsProject_BuildEmpty";
    final String NEW_BUILD_NAME = "Build";
    final String NEW_BUILD_ID = "BuildActionsProject_Build";

    TeamCityUISteps teamCityUISteps = new TeamCityUISteps();
    ProjectSteps projectSteps = new ProjectSteps();
    BuildConfigSteps buildConfigSteps = new BuildConfigSteps();
    BuildSteps buildSteps = new BuildSteps();
    BuildDropdownMenuSteps buildDropdownMenuSteps = new BuildDropdownMenuSteps();
    StopBuildDialogsSteps modalDialogsSteps = new StopBuildDialogsSteps();
    PinBuildDialogSteps pinBuildDialogSteps = new PinBuildDialogSteps();
    AddTagsDialogSteps addTagsDialogSteps = new AddTagsDialogSteps();
    ReRunBuildDialogSteps reRunDialogSteps = new ReRunBuildDialogSteps();
    RemoveBuildDialogSteps removeBuildDialogSteps = new RemoveBuildDialogSteps();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        configure();
    }

    @Test
    void manuallyRunBuildTest() {
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
                .runBuild()
                .showQueue()
                .shouldHaveStatusPassed();

        // delete BC
        bc.deleteBuildConfiguration();
    }

    @Test
    void pinBuildTest() {
        BuildConfigAPI bc = new BuildConfigAPI(getUserToken());
        // copy BC
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID);

        // run build
        bc.runBuild();

        // do UI
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(SOURCE_PROJECT_NAME);
        projectSteps
                .openBuild(NEW_BUILD_NAME);
        buildConfigSteps
                .showQueue()
                .shouldHaveStatusPassed()
                .openBuildDropDownMenu();
        buildDropdownMenuSteps
                .clickPinItem();
        pinBuildDialogSteps
                .setPinMessage("001rc")
                .clickPinButton();
        buildConfigSteps
                .showBuildInfo();
        buildSteps
                .shouldHavePinMessage("001rc");

        // delete BC
        bc.deleteBuildConfiguration();
    }

    @Test
    void addTagsToBuildTest() {
        BuildConfigAPI bc = new BuildConfigAPI(getUserToken());
        // copy BC
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID);

        // run build
        bc.runBuild();

        // do UI
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(SOURCE_PROJECT_NAME);
        projectSteps
                .openBuild(NEW_BUILD_NAME);
        buildConfigSteps
                .showQueue()
                .shouldHaveStatusPassed()
                .openBuildDropDownMenu();
        buildDropdownMenuSteps
                .clickAddTagsItem();
        addTagsDialogSteps
                .setTag("release")
                .clickSaveButton();
        buildConfigSteps
                .showBuildInfo();
        buildSteps
                .shouldHaveTag("release");

        // delete BC
        bc.deleteBuildConfiguration();
    }

    @Test
    void reRunBuildTest() {
        BuildConfigAPI bc = new BuildConfigAPI(getUserToken());
        // copy BC
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID);

        // run build
        bc.runBuild();

        // do UI
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(SOURCE_PROJECT_NAME);
        projectSteps
                .openBuild(NEW_BUILD_NAME);
        buildConfigSteps
                .showQueue()
                .shouldHaveStatusPassed()
                .openBuildDropDownMenu();
        buildDropdownMenuSteps
                .clickReRunItem();
        reRunDialogSteps
                .clickRunButton();
        buildConfigSteps
                .showQueue()
                .shouldHaveSecondBuild();

        // delete BC
        bc.deleteBuildConfiguration();
    }

    @Test
    void stopBuildTest() {
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
                .runBuild()
                .stopBuild();
        modalDialogsSteps
                .clickStopButton();
        buildConfigSteps
                .shouldHaveStatusCancel();

        // delete BC
        bc.deleteBuildConfiguration();
    }

    @Test
    void removeBuildTest() {
        BuildConfigAPI bc = new BuildConfigAPI(getUserToken());
        // copy BC
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID);

        // run build
        bc.runBuild();

        // do UI
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(SOURCE_PROJECT_NAME);
        projectSteps
                .openBuild(NEW_BUILD_NAME);
        buildConfigSteps
                .shouldHaveStatusPassed()
                .openBuildDropDownMenu();
        buildDropdownMenuSteps
                .clickRemoveItem();
        removeBuildDialogSteps
                .clickRemoveButton();
        buildConfigSteps
                .shouldHaveNoBuilds();

        // delete BC
        bc.deleteBuildConfiguration();
    }

    @Test
    void downloadBuildArtifactTest() throws IOException, URISyntaxException {
        BuildConfigAPI bc = new BuildConfigAPI(getUserToken());
        // copy BC
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID);

        // run build
        bc.runBuild();

        // do UI
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(SOURCE_PROJECT_NAME);
        projectSteps
                .openBuild(NEW_BUILD_NAME);
        buildConfigSteps
                .shouldHaveStatusPassed()
                .showBuildInfo();
        buildSteps
                .openArtifactsTab()
                .checkBuildFile();

        // delete BC
        bc.deleteBuildConfiguration();
    }

    @Test
    void addBuildToFavoriteTest() {
        BuildConfigAPI bc = new BuildConfigAPI(getUserToken());
        // copy BC
        bc.copyBuildConfiguration(SOURCE_PROJECT_NAME, SOURCE_BUILD_ID, NEW_BUILD_NAME, NEW_BUILD_ID);

        // run build
        bc.runBuild();

        // do UI
        teamCityUISteps
                .openFavoriteProjects()
                .openProject(SOURCE_PROJECT_NAME);
        projectSteps
                .openBuild(NEW_BUILD_NAME);
        buildConfigSteps
                .shouldHaveStatusPassed()
                .openBuildDropDownMenu();
        buildDropdownMenuSteps
                .clickAddToFavoritesItem();
        buildConfigSteps
                .shouldBeInFavorites();

        // delete BC
        bc.deleteBuildConfiguration();
    }
}
