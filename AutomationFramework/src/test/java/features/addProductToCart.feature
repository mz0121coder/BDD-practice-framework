Feature: Placing orders for products in the GreenKart store

  @checkout
  Scenario Outline: Adding products to the cart and going to the checkout page
    Given the user is on the GreenCart landing page
    When the user searches for "<search>" on the Home page
    And the user adds "<quantity>" of the product to their cart and goes to checkout
    Then the user sees the quantity "<quantity>" of the product "<search>" in their cart
    And can enter a promo code and place the order

    Examples:
      | search      | quantity |
      | cauliflower | 3        |
      | strawberry  | 5        |
      | carrot      | 6        |
      | mango       | 12       |