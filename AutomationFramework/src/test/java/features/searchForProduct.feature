Feature: Search and place the order for products

  Scenario Outline: Product search in Home page and Offers page
    Given the user is on the GreenCart landing page
    When the user searches for "<search>" on the Home page
    And the user searches again for "<search>" on the Offers page
    Then the product "<name>" is displayed on both pages

    Examples:
      | search | name       |
      | tom    | Tomato     |
      | straw  | Strawberry |
      | bri    | Brinjal    |
      | ban    | Banana     |
      | car    | Carrot     |
      | man    | Mango      |

