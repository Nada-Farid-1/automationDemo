@smoke
Feature: F07_followUs | users could open followUs links

  Scenario: user opens facebook link
    Given user in home page and follow us links appeared
    When user click on facebook link
    Then "https://www.facebook.com/nopCommerce" is opened in new tab

  #Step 1 user opens facebook link
  #Step 2 "https://www.facebook.com/nopCommerce" is opened in new tab

  Scenario: user opens twitter link
    Given user in home page and follow us links appeared
    When user click on twitter link
    Then "https://twitter.com/nopCommerce" is opened in new tab
 # Step 1 user opens twitter link
  #Step 2 "https://twitter.com/nopCommerce" is opened in new tab

  Scenario: user opens rss link
    Given user in home page and follow us links appeared
    When user click on rss link
    Then "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab
  #Step 1 user opens rss link
  #Step 2 "https://demo.nopcommerce.com/new-online-store-is-open" is opened in new tab

  Scenario: user opens youtube link
    Given user in home page and follow us links appeared
    When user click on youtube link
    Then "https://www.youtube.com/user/nopCommerce" is opened in new tab
  #Step 1 user opens youtube link
  #Step 2 "https://www.youtube.com/user/nopCommerce" is opened in new tab




  #What do you need to test in this feature?
#- go to https://demo.nopcommerce.com/ 2
#- you will find “Follow us” links at the end of the page
#- you need to create scenario for each button to make sure it works properly
# 1: user opens facebook link
#2: user opens twitter link
  # 3: user opens rss link

 #4: user opens youtube link
#Note: Scenario 3 will failed because the link doesn’t open a valid url
#actual result is nopCommerce demo store: News 2
#however expected result should be nopCommerce demo store. New online store is open!

#What you will learn?
#you will learn How to handle multiple windows in Selenium using getWindowHandles() method

#for example if you have (tab 0 , tab 1)
#you will learn how to switch between the two tabs and how to close tab 1 and get back to tab 0 and so on
#you could get help from this project
#https://github.com/KhaledAMRS/SeleniumCommands