#language: en
@Run
Feature: AXA Deltix Login

  Scenario: Successful login procedure.
  After entering the valid data and pressing the submit button,
  user should be redirected to the SUMMARY page,
  which has unique elements

    Given Deltix login page is opened
    When user sign in
    Then main page opens and "Settings" button is available
    And "Benchmark selector" is available
    And "Application toolbar" with all section is available
      | Summary      |
      | Grid & chart |
      | Histogram    |
      | Scatter-plot |
      | Reports      |