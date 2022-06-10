package steps;

import org.junit.jupiter.api.Tag;
import pages.BuildPage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class BuildSteps extends BuildPage {

    public BuildSteps openArtifactsTab() {
        step("Open artifacts tab", () -> {
            artifactsTab.click();
        });
        return this;
    }

    public BuildSteps checkBuildFile() throws IOException, URISyntaxException {
        step("Check if artifact download button is appear", () -> {
            artifactDownloadButton.should(appear);
            //String fileUrl = artifactDownloadButton.getAttribute("href");
            //File downloadFile = download(fileUrl);
            //downloadFile.delete();
        });
        return this;
    }

    public BuildSteps shouldHaveTag(String tag) {
        step("Check if tag " + tag + "is exists", () -> {
            tagsInfoBlock.shouldHave(text(tag));
        });
        return this;
    }

    public BuildSteps shouldHavePinMessage(String message) {
        step("Check if there is pin message " + message, () -> {
            pinnedInfoBlock.shouldHave(text(message));
        });
        return this;
    }


}
