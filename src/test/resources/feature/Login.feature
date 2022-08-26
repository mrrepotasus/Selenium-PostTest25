Feature: Checkout shop		
    
  Scenario: User Add item
  	Given User go to web Shop
    When User click Search first item
    And User add first item to cart
    Then User click Search second cart
    And User add Second item to cart
		Then User click view cart
		And User click view Checkout
		
	Scenario: User checkout
		When User input data
		And User click place order
		Then User Your order has been received