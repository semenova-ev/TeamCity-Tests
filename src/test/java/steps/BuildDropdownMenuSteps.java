package steps;

import pages.BuildDropdownMenuPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;

public class BuildDropdownMenuSteps extends BuildDropdownMenuPage {
    public BuildDropdownMenuSteps clickAddTagsItem() {
        step("Select Add tags menu item", () -> {
            dropDownMenuAddTagsItem.should(exist, Duration.ofSeconds(60));
            dropDownMenuAddTagsItem.click();
        });
        return this;
    }

    public BuildDropdownMenuSteps clickAddToFavoritesItem() {
        step("Select Add to favorite menu item", () -> {
            dropDownMenuAddToFavoritesItem.should(exist, Duration.ofSeconds(60));
            dropDownMenuAddToFavoritesItem.click();
        });
        return this;
    }

    public BuildDropdownMenuSteps clickReRunItem() {
        step("Select Rerun menu item", () -> {
            dropDownMenuReRunItem.should(exist, Duration.ofSeconds(60));
            dropDownMenuReRunItem.click();
        });
        return this;
    }

    public BuildDropdownMenuSteps clickRemoveItem() {
        step("Select Remove menu item", () -> {
            dropDownMenuRemoveItem.should(exist, Duration.ofSeconds(60));
            dropDownMenuRemoveItem.click();
        });
        return this;
    }

    public BuildDropdownMenuSteps clickPinItem() {
        step("Select Pin menu item", () -> {
            dropDownMenuPinItem.should(exist, Duration.ofSeconds(60));
            dropDownMenuPinItem.click();
        });
        return this;
    }
}
