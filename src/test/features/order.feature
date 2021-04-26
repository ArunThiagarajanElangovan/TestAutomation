Feature: To place a order for Automation practise in Retailer Online portal

  @test1
  Scenario: As a online customer, i need to place a order and verify order history
    Given user lands on login page
    When user enters email address and password
    And Click on First name on right top corner
    Then Changed personal information of first name

  @test2
  Scenario: As a online customer, i need to place a order and verify order history
    Given user lands on login page
    When user enters email address and password
    And  clicked T Shirt link, selected T Shirt and added to cart by accpeting T&C
    Then make payment by Bank wire and confirm Order



