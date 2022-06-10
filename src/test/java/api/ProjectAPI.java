package api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import static io.restassured.RestAssured.given;

public class ProjectAPI {
    private String projectId;
    private final String userToken;

    public ProjectAPI(String userToken) {
        this.userToken = userToken;
    }



    public void copyProject(String parentProjectLocator, String newProjectName, String newProjectId, String sourceProjectLocator) {
        if (parentProjectLocator.length() == 0) {
            parentProjectLocator = "_Root";
        }

        this.projectId = newProjectId;

        deleteProject();

        String requestBody = "{\"parentProject\":{\"locator\":\"" + parentProjectLocator +
                "\"},\"name\":\"" + newProjectName +
                "\",\"id\":\"" + newProjectId +
                "\",\"copyAllAssociatedSettings\":true,\"sourceProject\":{\"locator\":\"" + sourceProjectLocator + "\"}}";

        given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + userToken)
                .body(requestBody)
                .when()
                .post(Configuration.baseUrl + "/app/rest/projects/")
                .then().statusCode(200);
    }

    public void deleteProject() {
        deleteProject(this.projectId);
    }

    public void deleteProject(String projectId) {
        given()
                .header("Authorization", "Bearer " + userToken)
                .when()
                .delete(Configuration.baseUrl + "/app/rest/projects/id:" + projectId);

        Selenide.sleep(5000);
    }
}
