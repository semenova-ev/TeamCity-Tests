package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import pages.CreateProjectFromURLPage;

import java.time.Duration;

import static io.qameta.allure.Allure.step;

public class CreateProjectFromURLSteps extends CreateProjectFromURLPage {

    public CreateProjectFromURLSteps clickProceedButton() {
        step("Click Proceed button", () -> {
            vcsConnectionStatus.should(Condition.appear, Duration.ofMinutes(2));
            proceedButton.click();
            resultInfoBlock.shouldHave(Condition.text("successfully"), Duration.ofMinutes(5));
        });
        return this;
    }

    public CreateProjectFromURLSteps checkMaven() {
        step("Select checkbox of build step", () -> {
            mavenCheckBox.shouldBe(Condition.visible, Duration.ofSeconds(30));
            //Selenide.sleep(10000);
            mavenCheckBox.click();
        });
        return this;
    }

    public CreateProjectFromURLSteps clickUseSelectedButton() {
        step("Click on Use selected button", () -> {
            useSelectedButton.click();
            Selenide.sleep(5000);
        });
        return this;
    }
}
