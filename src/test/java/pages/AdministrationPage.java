package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AdministrationPage {
    protected final SelenideElement
            createProjectButton = $(".createProject").$(By.linkText("Create project"));
}
