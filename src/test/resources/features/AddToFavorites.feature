Feature: Add To Favorites on Ozon.ru

  Background:
    Given I opened My Favorites Page

  Scenario: Add To Favorites on Ozon.ru
    And I opened Product Details Page
    When I click Add To Favorites Button
    Then I see Number Of Favorites

  Scenario: Check Favorites
    And I opened My Favorites Page
    Then I see Book In Favorites
