@smoke
Feature: F01_Register | users could register with new accounts
  Scenario: guest user could register with valid data successfully

    Given user goto register page
    When user select a gender type
    And user enter first name "automation" and last name "tester" field
    And user enter the date of birth
    And user enter email "test30@example.com"
    And user fills Password fields "P@ssw0rd" "P@ssw0rd" fields
    And user clicks on the register button
    Then verify success message is displayed



