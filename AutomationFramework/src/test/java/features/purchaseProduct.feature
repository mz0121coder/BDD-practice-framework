Feature: Purchasing a product

  @purchase
  Scenario Outline: Add product to cart & complete the purchase
    Given the user is on the GreenKart landing page
    When the user searches for "<search>" on the Home page
    And the user adds "<quantity>" of the product to their cart and goes to checkout
    Then the user clicks the button to place the order
    And agrees to the terms & conditions and selects the country "<country>"
    Then proceeds to view a confirmation of the order
    And the user is redirected to the GreenKart landing page

    Examples:
      | search      | quantity | country        |
      | cauliflower | 3        | Argentina      |
      | strawberry  | 5        | Germany        |
      | carrot      | 6        | United Kingdom |
      | mango       | 12       | France         |