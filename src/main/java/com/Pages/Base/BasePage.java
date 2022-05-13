package com.Pages.Base;

import com.Pages.Base.Elements.NavigationBarElement;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class BasePage {
    public final NavigationBarElement navigator;
    private static final SelenideElement REFRESH_BUTTON = $x("//span[text()='Refresh']");

    public BasePage() {
        navigator = new NavigationBarElement();
        Configuration.browserSize = "1920x1080";
    }
    public void refresh(){
        REFRESH_BUTTON.click();
    }
}
