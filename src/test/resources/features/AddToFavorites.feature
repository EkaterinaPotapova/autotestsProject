Feature: Add To Favorites on Ozon.ru

  Scenario: Add To Favorites on Ozon.ru
    Given I opened Product Details Page
    When I click Add To Favorites Button
    Then I see Number Of Favorites

  Scenario: Check Favorites
    Given I opened My Favorites Page
    Then I see Book In Favorites

  Scenario: Search book
    Given I opened Home Page
    When I Search book
    Then I see Book Search result page


