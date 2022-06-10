package testData;

import com.codeborne.selenide.Configuration;
import steps.LoginSteps;

public class MainTestConfiguration {

    private static String userName;
    private static String userPass;
    private static String userToken;

    static public void configure() {
        Configuration.baseUrl = "https://semenova.teamcity.com";
        //Configuration.baseUrl = "http://51.250.97.59:8111/";
        Configuration.browserSize  = "1920x1080";

        userName = Users.mainUsername;
        userPass = Users.mainUserpass;
        userToken = Users.mainUsertoken;

        authorisation(Users.mainUsername, Users.mainUserpass);
    }

    static public String getUserName() {
        return userName;
    }
    static public String getUserPass() {
        return userPass;
    }
    static public String getUserToken() {
        return userToken;
    }

    static private void authorisation(String userName, String userPassword) {
        LoginSteps loginSteps = new LoginSteps();

        loginSteps
                .openLoginPage()
                .clickLoginByUserPass()
                .setUsername(userName)
                .setPassword(userPassword)
                .clickLoginButton();
    }
}
