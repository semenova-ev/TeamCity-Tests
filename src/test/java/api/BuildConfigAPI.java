package api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.is;

public class BuildConfigAPI {

    private String buildConfigurationId;
    private final String userToken;

    public BuildConfigAPI(String userToken) {
        this.userToken = userToken;
    }

    public void copyBuildConfiguration(String projectName, String targetBuildConfigurationId, String newBuildConfigurationName, String newBuildConfiguraionId) {
        this.buildConfigurationId = newBuildConfiguraionId;

        deleteBuildConfiguration();

        String requestBody = "{\"sourceBuildTypeLocator\":\"" + targetBuildConfigurationId +
                "\",\"name\":\"" +newBuildConfigurationName +
                "\",\"id\":\"" + newBuildConfiguraionId +
                "\",\"copyAllAssociatedSettings\":true}";

        given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + userToken)
                .body(requestBody)
                .when()
                .post(Configuration.baseUrl + "/app/rest/projects/" + projectName + "/buildTypes")
                .then().statusCode(200);
    }

    public void runBuild () {
        String requestBody = "{\"buildType\":{\"id\":\"" + buildConfigurationId + "\"}}";

        given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + userToken)
                .body(requestBody)
                .when()
                .post(Configuration.baseUrl + "/app/rest/buildQueue")
                .then().statusCode(200);

        Selenide.sleep(5000);
    }

    public void deleteBuildConfiguration() {
        deleteBuildConfiguration(this.buildConfigurationId);
    }

    public void deleteBuildConfiguration(String buildConfigId) {
        given()
                .header("Authorization", "Bearer " + userToken)
                .when()
                .delete(Configuration.baseUrl + "/app/rest/buildTypes/" + buildConfigId);

        Selenide.sleep(5000);
    }
}
