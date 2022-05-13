package com.Pages.Login;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {
    private static final String URL_LOGIN = "https://app.tca.deltixuat.com/login";
    private static final String LOGIN = "selenium_chrome";
    private static final String PASSWORD = "Axa@Demo";
    private static final SelenideElement INPUT_USERNAME = $x("//input[@formcontrolname = 'username']");
    private static final SelenideElement INPUT_PASSWORD = $x("//input[@formcontrolname = 'password']");
    private static final SelenideElement SIGN_BUTTON = $x("//button[@role = 'submit']");

    public void open(){
        Selenide.open(URL_LOGIN);
    }
    public void LogIn() {
        INPUT_USERNAME.setValue(LOGIN);
        INPUT_PASSWORD.setValue(PASSWORD);
        SIGN_BUTTON.click();
    }
}
