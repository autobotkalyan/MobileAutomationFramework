@LetsCart
Feature: To test Lets Cart Native application


  @BaseFlow
  Scenario Outline: Testing Base page of the application
    When I select country from the dropdown for <TestCase>
    And I enter Name in the text field
    And I click lets shop button
#    Then I am on Products screen
#    And I quit the application

    Examples:
      | TestCase |  |
      | TC001    |  |
#      | India   | Kumar |

  @Checkout
  Scenario: Testing the cart checkout flow
    When I select Belgium country from the dropdown
    And I enter KK in the text field
    And I click lets shop button
    And I am selecting the item Air Jordan 4 Retro
    Then I click cart button
    And I click the checkbox
    Then I click visit the website button




