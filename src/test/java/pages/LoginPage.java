package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    // locators
    protected final SelenideElement
            headerTitle = $("#loginPage #header"),
            continueWithUsernameLink = $("#loginPasswordSwitch"),
            loginForm = $("#loginForm"),
            usernameInput = $("#username"),
            passwordInput = $("#password"),
            loginButton = $(".loginButton"),
            headerPortal = $("#header-portal");
}
