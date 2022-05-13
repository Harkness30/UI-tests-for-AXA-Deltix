package com.Pages.Grid.Elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class Filters {
    private static final SelenideElement FILTERS = $x("//span[text()='Filters']");
    private static final SelenideElement ID_IN_FILTERS = $x("//div[@class='ag-column-tool-panel-container']//span[text()='Avg fill price']/preceding-sibling::span");
    private static final SelenideElement ID_GRID_COLUMN = $x("//div[@class='ag-header-cell ag-header-cell-sortable' and @col-id='averageFillPrice']");
    private static final SelenideElement ID_IN_TOOL_PANEL = $x("//div[@class='ag-primary-cols-list-panel']//span[text()='Avg fill price']/preceding-sibling::span");
    private static final SelenideElement TOOL_PANEL = $x("//span[text()='Columns']");
    private static final SelenideElement ID_GRID_FILTER = $x("//div[@class='ag-menu']//span[@class='ag-icon ag-icon-columns']");
    private static final SelenideElement ID_IN_COLUMN_FILTER = $x("//div[@class='ag-menu']//div[@class='ag-primary-cols-list-panel']//span[text()='Avg fill price']/preceding-sibling::span");

    public void openFilters() {
        FILTERS.click();
    }

    public void clickIdCheckbox() {
        ID_IN_FILTERS.click();
    }

    public SelenideElement getIdGridColumn() {
        return ID_GRID_COLUMN;
    }
    public void openToolPanel(){
        TOOL_PANEL.click();
    }
    public void clickIdInTools(){
        ID_IN_TOOL_PANEL.click();
    }
    public void openGridFilter(){
        $x("//div[@class='ag-header-cell ag-header-cell-sortable' and @col-id='averageFillPrice']//span[@ref='eMenu']").click();
        ID_GRID_FILTER.click();
    }
    public void clickIdInColumnFilter(){
        ID_IN_COLUMN_FILTER.click();
    }
}
