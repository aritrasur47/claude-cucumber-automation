Feature: Search and place the order for prdocuts

  @SearchProduct
  Scenario Outline: Search experience for product search on Home and Offers pages


    Given User is on Greenkart landing page
    When User searched with Shortname <VegName> and extracted actual name of the product
    Then User searched for <VegName> Shortname in the offers page
    And Validate product name in offers page matches with landing page

    Examples:
      | VegName |
      | Tom     |
      | Car     |

    @KnownFailure
    Examples:
      | VegName |
      | Beet	|
