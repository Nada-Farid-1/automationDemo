@smoke
Feature: F06_homeSliders | check sliders is clickable on home page
Scenario: first slider is clickable on home page
Given verify user go to Home page
  When click on First Slider
  Then user redirect to url1 Nokia
  Scenario: second slider is clickable on home page
    Given verify user go to Home page
    When click on Second Slider
    Then user redirect to url2 iphone
