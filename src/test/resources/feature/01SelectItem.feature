Feature: Select Item shop	
    
  Scenario: User Add item
  	When User go to web Shop
    And User click Search first item
    And User add first item to cart
    Then User click Search second cart
    And User add Second item to cart
		Then User click view cart
		And User click view Checkout