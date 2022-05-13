package com.Pages.Base.Elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class NavigationBarElement {
    private static final SelenideElement BAR = $x("//div[@class='ml-1 modes']");

    public SelenideElement getBar(){return BAR;}

    public void goTo(BarElements direction) {
        $x(direction.getValue()).click();
    }

    public SelenideElement getElement(String name) {
        return switch (name) {
            case "Summary" -> $x(BarElements.SUMMARY.getValue());
            case "Grid & chart" -> $x(BarElements.GRID.getValue());
            case "Histogram" -> $x(BarElements.HISTOGRAM.getValue());
            case "Scatter-plot" -> $x(BarElements.SCATTER.getValue());
            case "Reports" -> $x(BarElements.REPORTS.getValue());
            default -> null;
        };
    }
}
