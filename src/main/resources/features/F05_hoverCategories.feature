@smoke
Feature: F05_hoverCategories | user could select different Categories
  Scenario: Logged user could select different Categories
  Given user in Home Page and there are 3 main categories contains sub-categories
  When user select a category by hover on on it
  And user select a subcatgoriy by click on it
  And user get the name if the page title
  Then user verify that the sub-category title as the the selected random sub-category
