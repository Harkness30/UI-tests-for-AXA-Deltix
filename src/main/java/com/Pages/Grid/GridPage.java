package com.Pages.Grid;

import com.Pages.Base.BasePage;
import com.Pages.Grid.Elements.Filters;
import com.Pages.Grid.Elements.Sorter;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class GridPage extends BasePage {
    private static final String GRID_ORDER = "//div[@ref ='eCenterContainer']/div[@role='row']";
    private static final SelenideElement GRID_LINES_BUTTON = $x("//span[text()='+ Lines']");
    private static final SelenideElement EX_PRICE_IN_STRING = $x("//div[@class='chart-view__info mb-2 hidden-text']/div");
    private static final SelenideElement EX_PRICE_IN_LEGEND = $x("//span[text()='Avg fill price']/following-sibling::div[@Class='legend-container__item-value']");
    private static final SelenideElement EX_PRICE_IN_TOOLTIP = $("g[class$='AVERAGE_EXECUTION_PRICE']>text");
    private static final SelenideElement COLOR_EXEC = $("g[class$='AVERAGE_EXECUTION_PRICE']>rect");
    private static final SelenideElement MID_PRICE_IN_LEGEND = $x("//span[text()='Mid price']/following-sibling::div[@Class='legend-container__item-value']");
    private static final SelenideElement MID_PRICE_IN_TOOLTIP = $("g[class$='MID_PRICE']>text:last-child");
    public Filters filters = new Filters();
    public Sorter sorter = new Sorter();

    public String getOrder() {
        return GRID_ORDER;
    }

    public double getMidPriceFromLegend() {
        return Double.parseDouble(MID_PRICE_IN_LEGEND.getText());
    }

    public double getMidPriceFromTooltip() {
        return Double.parseDouble(MID_PRICE_IN_TOOLTIP.getText());
    }

    public void selectExecutableOrder() {
        int count = 1;
        String s = EX_PRICE_IN_STRING.getText();
        int index = s.indexOf("executions:");
        int index2 = s.indexOf(",", index + 11);
        String s2 = s.substring(index + 13, index2);
        if (Integer.parseInt(s2) < 2) {
            do {
                $x(GRID_ORDER + "[" + count + "]").click();
                count++;
            }
            while (Integer.parseInt(s2) < 2);
        }

    }

    public Double getPriceFromString() {
        String temp = EX_PRICE_IN_STRING.getText();
        int index = temp.indexOf("Exec price:");
        int index2 = temp.indexOf(",", index + 11);
        String result = temp.substring(index + 11, index2);
        return Double.parseDouble(result);
    }

    public Boolean checkTicksColor(String color) {
        String temp = EX_PRICE_IN_STRING.getText();
        int index = temp.indexOf(":");              // order id
        int index2 = temp.indexOf(",", index);
        String s2 = temp.substring(index + 3, index2);
        SelenideElement element = $x("//div[@row-id='" + s2 + "']//div[@col-id='priceImprovementToBenchmark' and contains(@class,'grid-" + color + "-cell')]");
        return element.is(exist);
    }

    public Boolean checkAmountColor(String color) {
        String temp = EX_PRICE_IN_STRING.getText();
        int index = temp.indexOf(":");
        int index2 = temp.indexOf(",", index);
        String s2 = temp.substring(index + 3, index2);
        SelenideElement element = $x("//div[@row-id='" + s2 + "']//div[@col-id='priceImprovementToBenchmarkAmount' and contains(@class,'grid-" + color + "-cell')]");
        return element.is(exist);
    }

    public Double getPriceFromGrid() {
        String temp = EX_PRICE_IN_STRING.getText();
        int index = temp.indexOf(":");
        int index2 = temp.indexOf(",", index);
        String s2 = temp.substring(index + 3, index2);
        String result = $x("//div[@row-id='" + s2 + "']/div[@col-id='averageFillPrice']/span").getText();
        return Double.parseDouble(result);
    }

    public Double getPriceFromLegend() {
        String result = EX_PRICE_IN_LEGEND.shouldBe(visible).getText();
        return Double.parseDouble(result);
    }

    public Double getPriceFromTooltip() {
        String result = EX_PRICE_IN_TOOLTIP.shouldBe(visible).getText();
        return Double.parseDouble(result);
    }

    public SelenideElement getLinesButton() {
        return GRID_LINES_BUTTON;
    }

    public boolean checkLinesElement(String name){
        return $x(String.format("//span[@title='%s']/../label/input", name)).is(checked);
    }

    public SelenideElement getLinesElement(String name) {
        return $x(String.format("//span[@title='%s']/../label", name));
    }

    public String getColor() {
        String color = COLOR_EXEC.getAttribute("fill");
        return switch (color) {
            case "#008000" -> "green";
            case "#FF0000" -> "red";
            default -> null;
        };
    }

}
