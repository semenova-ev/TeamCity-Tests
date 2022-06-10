package steps;

import pages.LoginPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LoginSteps extends LoginPage {

    public LoginSteps openLoginPage() {
        step("Open login page", () -> {
            open("/login.html");
            headerTitle.shouldHave(text("Log in to TeamCity"));
        });
        return this;
    }

    public LoginSteps clickLoginByUserPass() {
        step("Click on continue with username/password link", () -> {
            continueWithUsernameLink.click();
            loginForm.shouldHave(text("Username"));
        });
        return this;
    }

    public LoginSteps setUsername(String username) {
        step("Enter username " + username, () -> {
            usernameInput.setValue(username);
        });
        return this;
    }

    public LoginSteps setPassword(String password) {
        step("Enter password " + password, () -> {
            passwordInput.setValue(password);
        });
        return this;
    }

    public LoginSteps clickLoginButton() {
        step("Click on Login button", () -> {
            loginButton.click();
            headerPortal.shouldHave(text("Projects"));
        });
        return this;
    }
}
