@smoke
Feature: Search |  User could search for any product
  Scenario Outline: user could search using product name
    Given verify user go to Home page
    When user click on search field1
    And user enter product name "<productname>" search
    And user click on enter to show search result1
    Then user can show the search result1
    Examples:
      | productname |
      | book |
      | laptop |
      | nike |


  Scenario Outline: user could search for product using sku
    Given verify user go to Home page
    When user click on search field1
   And user enter product sku "<sku>"search
    Then user can show the PDP for enter sku
    Examples:
      | sku |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
