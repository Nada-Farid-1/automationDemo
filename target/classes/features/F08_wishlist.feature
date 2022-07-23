@smoke
Feature: F08_Wishlist | user can add item to his wishlist
  Scenario: verify that the user can add item to wishlist successfully
  Given user in Home page and there are product list
  When User click on heart for item
  Then user show success message The product has been added to your wishlist with green background color

  Scenario: verify that count of the wishlist responding
    Given user in Home page and there are product list
    When User click on heart for item
    Then wait until this success message with green color to disappear then click on Wishlist Tab
    And get Qty value and verify it's bigger than zero

