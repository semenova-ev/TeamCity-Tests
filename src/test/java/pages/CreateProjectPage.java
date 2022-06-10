package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateProjectPage {

    protected final SelenideElement
            fromRepositoryURLButton = $(By.linkText("From a repository URL")),
            parentProjectInput = $("#-ufd-teamcity-ui-parentId"),
            repositoryURL = $("#url"),
            proceedButton = $(".submitButton");

}
