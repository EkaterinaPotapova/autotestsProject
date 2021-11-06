Feature: Search book on Ozon.ru

  Scenario Outline: Search book with <value1> and <value2>
    Given I opened Home Page
    When I Search book with <value1> and <value2>
    Then I see Book Search result page
    Examples:
      | value1 | value2 |
      | "Selenium Framework"|"Selenium Framework Design in Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and TestNG"|
      | "in Data-Driven Testing"|"Selenium Framework Design in Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and TestNG"|
      | "Selenium WebDriver"|"Selenium Framework Design in Data-Driven Testing. Build data-driven test frameworks using Selenium WebDriver, AppiumDriver, Java, and TestNG"|

