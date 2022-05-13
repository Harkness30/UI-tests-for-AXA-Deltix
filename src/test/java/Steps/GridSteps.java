package Steps;

import com.Pages.Base.Elements.BarElements;
import com.Pages.Grid.GridPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$x;

public class GridSteps extends LoggerBaseStepDefinitions {

    GridPage gridPage;

    private List<String> autoSortedColumn;
    private List<String> handsSortedColumn;

    @Description("Description: Test case checks that same price values in different places are equal")
    @Given("user is signed in and Grid view is opened")
    public void start() {
        gridPage = new GridPage();
        gridPage.navigator.goTo(BarElements.GRID);
        log.info("Grid test started.");
    }

    @Step("Step - selecting an order")
    @When("user Selects an order")
    public void userSelectsAnOrder() {
        $x(gridPage.getOrder()).shouldBe(visible).click();
        log.error("Element " + gridPage.getOrder() + " not found");
    }

    @And("click on the +Lines button")
    public void clickOnTheLinesButton() {
        gridPage.getLinesButton().shouldBe(visible).click();
        log.error("Element \"+Lines button\" not found");
    }

    @Step("Step - selecting needed values in +Lines filter")
    @And("toggles the visibility of {string} and {string} in the Prices section")
    public void togglesTheVisibilityOfAndInThePricesSection(String s1, String s2) {
        gridPage.getLinesElement(s1).shouldBe(visible);
        if (!gridPage.checkLinesElement(s1)) {
            gridPage.getLinesElement(s1).click();
        }
        if (!gridPage.checkLinesElement(s2)) {
            gridPage.getLinesElement(s2).click();
        }
        gridPage.getLinesButton().click();
    }

    @Step("Step - selecting an order, witch have more than 1 execution")
    @And("selects an order with executions")
    public void selectsAnOrderWithExecutions() {
        gridPage.selectExecutableOrder();
        log.error("Executable order not found!");
    }

    @Step("Step - making sure values matches")
    @Then("the value of Exec price in the tooltip should match Avg fill price in the Interactive legend control")
    public void theValueOfExecPriceInTheTooltipShouldMatchAvgFillPriceInTheInteractiveLegendControl() {
        try {
            Assert.assertEquals(gridPage.getPriceFromTooltip(), gridPage.getPriceFromLegend());
            Assert.assertEquals(gridPage.getPriceFromTooltip(), gridPage.getPriceFromString());
            Assert.assertEquals(gridPage.getPriceFromTooltip(), gridPage.getPriceFromGrid());
        } catch (NoSuchElementException e) {
            log.error("Element not found", e);
        }
    }

    @Step("Step - making sure colors of lines for the same values matches")
    @And("the color of the Exec line matches with text color of Price imp. \\(ticks) and Price imp. \\(amount)")
    public void colorOfExecLineMatchesWithTextColorOfPriceImpTicksAndPriceImpAmount() {
        Assert.assertTrue(gridPage.checkTicksColor(gridPage.getColor()));
        Assert.assertTrue(gridPage.checkAmountColor(gridPage.getColor()));
    }

    @Step("Step - making sure values matches")
    @And("the value of the Mid price in the Interactive legend control matches with its value in the tooltip")
    public void theValueOfMidPriceInTheInteractiveLegendControlMatchesWithItsValueInTheTooltip() {
        Assert.assertEquals(gridPage.getMidPriceFromTooltip(), gridPage.getMidPriceFromLegend());
        log.info("Avg fill price and Mid price test complete.");
    }

    @Description("Test case checks if filters for Grid works well")
    @Step("Step - opening filter and unchecking one of the columns")
    @When("user opens the Filters configurator and uncheck the column")
    public void userClickOnFiltersButton() {
        log.info("Grid filters test started.");
        gridPage.filters.openFilters();
        gridPage.filters.clickIdCheckbox();
    }

    @Step("Step - making sure column is back in Grid")
    @Then("column appears in the grid")
    public void columnAppearsFromTheGrid() {
        try {
            gridPage.filters.getIdGridColumn().should(exist);
        } catch (NoSuchElementException e) {
            log.error("Filter dropped! Column didn't appeared!", e);
        }
    }

    @Step("Step - taking back the column")
    @When("user check the column back in Filters")
    public void userUncheckTheColumnIbFilters() {
        gridPage.filters.clickIdCheckbox();
    }

    @Step("Step - making sure column is gone from Grid")
    @Then("column disappears from grid")
    public void columnDisappearsFromGrid() {
        try {
            gridPage.filters.getIdGridColumn().shouldNot(exist);
        } catch (NoSuchElementException e) {
            log.error("Tool tips filter error! Column didn't appeared!", e);
        }

    }

    @Step("Step - uncheck the column")
    @When("user opens the Tool panel and  uncheck the column")
    public void userOpensTheToolPanelAndUncheckTheColumn() {
        gridPage.filters.openToolPanel();
        gridPage.filters.clickIdInTools();
    }

    @Step("Step - taking back the column in tool panel")
    @When("user check the column back in Tool panel")
    public void userCheckTheColumnInToolPanel() {
        gridPage.filters.clickIdInTools();
    }

    @Step("Step - opening grid-filter and unchecking the column")
    @When("user opens the column-filter in Grid and uncheck the column")
    public void userOpensTheColumnFilterInGridAndUncheckTheColumn() {
        gridPage.filters.openGridFilter();
        gridPage.filters.clickIdInColumnFilter();
    }

    @Step("Step - making sure it's back")
    @When("user check the column back in column-filter in Grid")
    public void userCheckTheColumnInColumnFilterInGrid() {
        gridPage.filters.clickIdInColumnFilter();
    }

    @Description("Description: Test Case checks the grid-sorting feature.")
    @Step("Step - set sorting in the column")
    @When("user clicks on the {string} header")
    public void userClicksOnTheHeaderToApplySort(String columnName) {
        try {
            gridPage.sorter.getColumnRoot(columnName).scrollIntoView(true).click();
        } catch (NoSuchElementException e) {
            log.error("Column not found!", e);
        }
    }

    @Step("Step - making sure the column sorted")
    @Then("{string} should be sorted")
    public void shouldBeSorted(String columnName) {
        gridPage.sorter.getColumnElement(columnName).shouldBe(visible);
        autoSortedColumn = gridPage.sorter.getColumnValues(columnName);
        autoSortedColumn.remove(autoSortedColumn.size() - 1);
        handsSortedColumn = autoSortedColumn.stream().sorted().collect(Collectors.toList());
        Assert.assertEquals(autoSortedColumn, handsSortedColumn);
        log.info("Sort test for column" + columnName + "passed.");
    }

    @Step("Step - making sure column reversed")
    @Then("{string} should be reversed")
    public void shouldBeReversed(String columnName) {
        gridPage.sorter.getColumnElement(columnName).shouldBe(visible);
        autoSortedColumn = gridPage.sorter.getColumnValues(columnName);
        autoSortedColumn.remove(autoSortedColumn.size() - 1);
        handsSortedColumn = autoSortedColumn.stream().sorted((o1, o2) -> -o1.compareTo(o2)).collect(Collectors.toList());
        Assert.assertEquals(autoSortedColumn, handsSortedColumn);
        log.info("Reversed-sort test for column" + columnName + "passed.");
    }

    @Step("Step - making sure that column unsorted")
    @Then("{string} should become unsorted")
    public void shouldBecomeUnsorted(String columnName) {
        gridPage.sorter.getColumnElement(columnName).shouldBe(visible);
        autoSortedColumn = gridPage.sorter.getColumnValues(columnName);
        handsSortedColumn = autoSortedColumn.stream().sorted().collect(Collectors.toList());
        Assert.assertNotEquals(autoSortedColumn, handsSortedColumn);
        log.info("Test case passed.");
    }
}
