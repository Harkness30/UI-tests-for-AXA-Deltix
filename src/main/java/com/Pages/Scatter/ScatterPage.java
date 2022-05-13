package com.Pages.Scatter;

import com.Pages.Base.BasePage;
import com.Pages.Base.Elements.AttributesPanelElement;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.an.Y;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class ScatterPage extends BasePage {
    private static final SelenideElement SCATTER = $x("//div[@class='scatter-plot-container']");
    private static final SelenideElement INTERVAL = $x("//*[@name='intervalCountAutocomplete']//input");    //для панели интервалов
    private static final SelenideElement X_AXIS = $("g[class='x axis']");
    private static final SelenideElement Y_AXIS = $("g[class='y axis']");
    private static final SelenideElement X_AXIS_LABEL = $x("//*[@class='scatter-plot-x-label']");
    private static final SelenideElement Y_AXIS_LABEL = $x("//*[@class='scatter-plot-y-label']");
    private static final List <SelenideElement> GRID_ELEMENTS = $$(".scatter_element");
    public AttributesPanelElement X_ATTRIBUTE = new AttributesPanelElement("//div[text()='X Attribute']/following-sibling::*"); // оба объекта предназначены для выбора
    public AttributesPanelElement Y_ATTRIBUTE = new AttributesPanelElement("//div[text()='Y Attribute']/following-sibling::*"); // атрибутов для соответствующих осей

    public void setInterval(int value) {
        INTERVAL.click();
        if (value != 10&&value>=2&&value<=50) {
            INTERVAL.click();
            INTERVAL.setValue(Integer.toString(value));
            INTERVAL.pressEnter();
        }
    }
    public SelenideElement getXs(){
        return X_AXIS;
    }
    public SelenideElement getYs(){
        return Y_AXIS;
    }
    public SelenideElement getXLabel(){
        return X_AXIS_LABEL;
    }
    public SelenideElement getYLabel (){
        return Y_AXIS_LABEL;
    }
    public List<SelenideElement> getGridElements(){
        return GRID_ELEMENTS;
    }
    public SelenideElement getScatter (){
        return SCATTER;
    }
}
