package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class CreateProjectFromURLPage {

    protected final SelenideElement
            proceedButton = $(".submitButton"),
            mavenCheckBox = $(".custom-checkbox"),
            useSelectedButton = $(By.linkText("Use selected")),
            vcsConnectionStatus = $(".connectionSuccessful"),
            //resultInfoBlock = $("#message_objectsCreated");
            resultInfoBlock =$("#main-content-tag");

}
