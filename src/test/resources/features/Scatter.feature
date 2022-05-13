#language: en
@Run
Feature: AXA Deltix Scatter

  Background:
    Given user is signed in and Scatter-plot view is opened

  @Parametrized
  Scenario Outline:Scatter-plot View. Scatter, its axis and titles should be updated when changing its Attributes
    Given there is "Exec size" selected as X-attribute
    And there is "Realized market impact" selected as Y-attribute
    And intervals set as 10
    When user changes the X-attribute to "<X>"
    Then values of axes should be updated "<X>"
    And the name of the X-axis should change to "<X>" Attribute
    When user changes the Y-attribute to "<Y>"
    Then values updated
    And the name of the Y-axis should change to "<Y>" attribute
    And grid should collapse

    Examples:
      | X                          |  | Y                          |
      | Avg fill price             |  | Avg fill price             |
      | Num of executions          |  | Exec size                  |
      | Price                      |  | Num of executions          |
      | Size                       |  | Price                      |
      | Execution price volatility |  | Size                       |
      | Realized market impact     |  | Execution price volatility |
      | Participation rate         |  | Participation rate         |
      | Shortfall                  |  | Shortfall                  |
      | Multiplier                 |  | Multiplier                 |
      | Tick size                  |  | Tick size                  |
      | Currency code              |  | Currency code              |
      | Sequence number            |  | Sequence number            |
      | Db sequence number         |  | Db sequence number         |
      | Benchmark price            |  | Benchmark price            |
      | Price imp. (ticks)         |  | Price imp. (ticks)         |
      | Price imp. (amount)        |  | Price imp. (amount)        |

