package com.Pages.Base.Elements;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;


public class AttributesPanelElement {

    private SelenideElement PANEL;
    private static final SelenideElement ATTRIBUTES_LIST = $x("//ul[@class='autocomplete-dropdown-menu']");


    public AttributesPanelElement(String path) {
        PANEL = $x(path);
    }

    public void selectAttribute(Attributes attribute) {
        PANEL.click();
        $x(String.format("//ul/li[@title='%s']", attribute.getValue())).click();
    }
    public void selectAttribute(String attribute) {
        PANEL.click();
        $x(String.format("//ul/li[@title='%s']", attribute)).click();
    }
}
