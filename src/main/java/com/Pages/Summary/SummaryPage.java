package com.Pages.Summary;

import com.Pages.Base.BasePage;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SummaryPage extends BasePage {
    private static final SelenideElement ALGO_PERFORMANCE = $x("//div[text()='Algo Performance']/../../following-sibling::div");
    private static final SelenideElement SETTINGS_BUTTON = $("[data-icon='cog']");
    private static final SelenideElement BENCHMARK_SELECTOR = $("[title^='Benchmark']");


    public SelenideElement getElement(String name){
        return switch (name) {
            case "Settings" -> SETTINGS_BUTTON;
            case "Benchmark selector" -> BENCHMARK_SELECTOR;
            case "Application toolbar" -> navigator.getBar();
            default -> null;
        };
    }

}
