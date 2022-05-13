package com.Pages.Base.Elements;

public enum BarElements {
    SUMMARY("//div[text()='Summary']"),
    GRID("//div[text()='Grid & chart']"),
    HISTOGRAM("//div[text()='Histogram']"),
    SCATTER("//div[text()='Scatter-plot']"),
    REPORTS("//div[text()='Reports']");

    private String value;

    BarElements(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}


