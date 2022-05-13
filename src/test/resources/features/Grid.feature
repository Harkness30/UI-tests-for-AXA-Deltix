#language: en
@Run
Feature: AXA Deltix Grid & chart

  Background:
    Given user is signed in and Grid view is opened

  Scenario: Check Avg fill price and Mid price. When choosing an order,
  correct information about its price should be displayed in different parts of the page

    When user Selects an order
    And click on the +Lines button
    And toggles the visibility of "Avg fill price" and "Mid price" in the Prices section
    And selects an order with executions
    Then the value of Exec price in the tooltip should match Avg fill price in the Interactive legend control
    And the color of the Exec line matches with text color of Price imp. (ticks) and Price imp. (amount)
    And the value of the Mid price in the Interactive legend control matches with its value in the tooltip


  Scenario: Check columns visibility when filters are applied to them
    When user opens the Filters configurator and uncheck the column
    Then column disappears from grid
    When user check the column back in Filters
    Then column appears in the grid
    When user opens the Tool panel and  uncheck the column
    Then column disappears from grid
    When user check the column back in Tool panel
    Then column appears in the grid
    When user opens the column-filter in Grid and uncheck the column
    Then column disappears from grid
    When user check the column back in column-filter in Grid
    Then column appears in the grid

  @Parametrized
  Scenario Outline: Check columns sort
    When user clicks on the "<column>" header
    Then "<column>" should be sorted
    When user clicks on the "<column>" header
    Then "<column>" should be reversed
    When user clicks on the "<column>" header
    Then "<column>" should become unsorted
    Examples:
      | column             |
      | orderInstrument    |
      | startTime          |
      | numberOfExecutions |
      | averageFillPrice   |
