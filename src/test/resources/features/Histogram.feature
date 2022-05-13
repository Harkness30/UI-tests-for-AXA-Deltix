#language: en
@Run
Feature: AXA Deltix Histogram

  Background:
  Given User is signed in and Histogram view is opened

  Scenario Outline: Histogram view. In case hovering over the histogram, the correct information should be displayed
    When user hover over a bar <x>
    Then boundaries displayed
    And number of orders displayed
    Then user click over the bar
    Examples:
      | x |
      | 0 |
      | 1 |
