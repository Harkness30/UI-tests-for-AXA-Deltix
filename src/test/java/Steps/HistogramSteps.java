package Steps;

import com.Pages.Histogram.HistogramPage;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

import static com.Pages.Base.Elements.BarElements.*;
import static com.codeborne.selenide.Condition.*;


public class HistogramSteps extends LoggerBaseStepDefinitions {

    public HistogramPage histogramPage;
    public SelenideElement Bar;

    @Description("Description: Test case checking do histogram provides correct data in case of interacting with it.")
    @Given("User is signed in and Histogram view is opened")
    public void userIsSignedInAndHistogramViewIsOpened() {
        histogramPage = new HistogramPage();
        histogramPage.navigator.goTo(HISTOGRAM);
        log.info("Histogram test started.");
    }

    @Step("Step - hover on each bar in turn")
    @When("user hover over a bar {int}")
    public void userHoverOverABar(int index) {
        Bar = histogramPage.getBars().get(index).shouldBe(visible);
        Bar.hover();
        log.info("Bar " + (index + 1) + " found.");
    }
    @Step("Step - check data was displayed")
    @Then("boundaries displayed")
    public void boundariesDisplayed() {
        histogramPage.getBoundaries().shouldBe(visible);
        log.error("Element " + histogramPage.getBoundaries().getText() + " not found!");
    }
    @Step("Step - check data was displayed")
    @And("number of orders displayed")
    public void numberOfOrdersDisplayed() {
        histogramPage.getCount().shouldBe(visible);
        log.error("Element " + histogramPage.getCount().getText() + " not found!");
    }
    @Step("Step - click on the bar")
    @Then("user click over the bar")
    public void userClickOnTheBar() {
        Bar.click();
        log.info("Current bar test complete");
    }


}
