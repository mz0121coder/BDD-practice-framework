Feature: Search and place the order for products

  Scenario: Product search in Home page and Offers page
    Given the user is on the GreenCart landing page
    When the user searches for "tom" on the Home page
    And the user searches again for "tom" on the Offers page
    Then the product "Tomato" is displayed on both pages