@smoke
Feature: F03_Currencies | User could switch between currencies US-Euro
  Scenario: Logged User could switch between currencies US-Euro
    Given verify user go to Home page
    When user select currency type
    Then user can show the changed currency
    And user showed the Euro Symbol (€) is shown on the four products displayed in Home page