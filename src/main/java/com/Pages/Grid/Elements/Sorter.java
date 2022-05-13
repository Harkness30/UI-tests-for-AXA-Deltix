package com.Pages.Grid.Elements;

import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class Sorter {

    public SelenideElement getColumnRoot(String column){
        return $(String.format("div[class^=ag-header] [col-id='%s']", column));
    }

    public List<String> getColumnValues(String column){
        return $$x(String.format("//div[@role='gridcell' and @col-id='%s']", column)).texts();
    }
    public List<SelenideElement> getColumnElements(String column){
        return $$x(String.format("//div[@role='gridcell' and @col-id='%s']", column));
    }
    public SelenideElement getColumnElement(String column){
        return $x(String.format("//div[@role='gridcell' and @col-id='%s']", column));
    }
}
