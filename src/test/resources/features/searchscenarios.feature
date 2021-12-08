Feature: Search scenarios

  Scenario: search product and add to basket
    Given start page is opened
    When type "macbook" into search field and click search
    Then this product is found
    And choose first product in the list
    And add this product to basket
    Then basket counter is updated