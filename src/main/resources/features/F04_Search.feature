@smoke
Feature: F04_Search |  User could search for any product
  Scenario Outline: user could search using product name
    Given verify user go to Home page
    When user click on search field
    And user enter product name "<productname>" in search field
    And user click on enter to show search result
    Then user can show the search result
    Examples:
      | productname |
      | book |
      | laptop |
      | nike |


  Scenario Outline: user could search for product using sku
    Given verify user go to Home page
    When user click on search field
   And user enter product sku "<sku>" in search field
    Then user can show the PDP for entered sku
    Examples:
      | sku |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
