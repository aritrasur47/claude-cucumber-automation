Feature: Place the order for prdocuts

  @PlaceOrder
  Scenario Outline: Search experience for product search in both home and offers page
:

    Given User is on Greenkart landing page
    When User searched with Shortname <VegName> and extracted actual name of the product
    And Added "3" items of the selected product to cart
    Then User proceeds to checkout page and validate the <VegName> items in checkout page
    And Verify user has ability to enter promo code and place the order

    Examples:
      | VegName |
      | Tom     |
