package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BuildDropdownMenuPage {
    protected final SelenideElement

            dropDownMenu = $(by("data-test", "ring-popup")),
            dropDownMenuPinItem = dropDownMenu.$(by("title", "Pin...")),
            dropDownMenuAddTagsItem = dropDownMenu.$(by("title", "Add tags...")),
            dropDownMenuAddToFavoritesItem = dropDownMenu.$(by("title", "Add to favorites")),
            dropDownMenuReRunItem = dropDownMenu.$(byText("Re-run this build...")),
            dropDownMenuRemoveItem = dropDownMenu.$(byText("Remove..."));
}
