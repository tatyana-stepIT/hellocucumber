Feature: Checkout from store

  @Start
  Scenario Outline: Login to app
    Given the app login page is open
    When the user enters correct <username> and <password>
    Then the user is logged in
    And the cart is empty


    Examples:
      | username      | password     |
      | standard_user  | secret_sauce |

  @Stop
  Scenario: Add product to cart
    Given the app is on products page
    When the user adds to cart product
      |Sauce Labs Onesie    |
      |Sauce Labs Bike Light|
    Then the cart counter is updated by 2

