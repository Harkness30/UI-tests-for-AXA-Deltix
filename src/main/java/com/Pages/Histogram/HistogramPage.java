package com.Pages.Histogram;

import com.Pages.Base.BasePage;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;

public class HistogramPage extends BasePage {

    private static final SelenideElement HISTOGRAM = $(".histogram");
    private static final List<SelenideElement> HISTOGRAM_BARS = $$(".bar");
    private static final SelenideElement BOUNDARIES = $x("//div[contains(text(),'Avg fill price:')]");
    private static final SelenideElement COUNT = $x("//div[contains(text(),'Count:')]");

    public List<SelenideElement> getBars(){
        return HISTOGRAM_BARS;
    }
    public SelenideElement getBoundaries(){
        return BOUNDARIES;
    }
    public SelenideElement getCount(){
        return COUNT;
    }
}
