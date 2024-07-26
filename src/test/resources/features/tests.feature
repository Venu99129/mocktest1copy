Feature: NopCommerce website operations

  Scenario: Verify item added successfully in the cart
    Given user open the website
    Then verify user is on home page
    When user click on login
    Then verify user is on login page
    When user enter valid login credentials
    And user click on login button
    Then verify user is on userHome page
    When user click on cell phones
    Then verify user is on cell phones items page
    When user add first product into cart









