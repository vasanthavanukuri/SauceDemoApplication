Feature: SauceDemoPage 
	In order to order a product in Saucedemo page
    As a e-commerce vendor
    I want to get access to the portal
    


Scenario Outline: Login with ValidCredentials 
	Given I have a browser with sauceDemoPage 
	When I enter userName as '<userName>' and I enter password as  '<password>' 
	Then I should access to the portal 
	Examples: 
		|userName|password|
		|standard_user|secret_sauce|
		|problem_user|secret_sauce|
		|performance_glitch_user|secret_sauce|
		
Scenario: Login with InvalidCredentials 
	Given I have a browser with sauceDemoPage 
	When I enter userName as 'locked_out_user' and I enter password as  'secret_sauce' 
	Then I should not get access to the portal 
	
Scenario: Login with empty userName 
	Given I have a browser with sauceDemoPage 
	When I enter userName as '' and I enter password as  'secret_sauce' 
	Then I should get username is required message 
	
Scenario: Sorting products in Price(low to high) order 
	Given I have a browser with sauceDemoPage and open products page 
	When I click on Dropdown Box and selecting Price(low to high) 
	Then Page should display the products in the  order of low to high price 
	
Scenario: Sorting products in Price(high to low) order 
	Given I have a browser with sauceDemoPage and open products page 
	When I click on Dropdown Box and selecting Price(high to low) 
	Then Page should display the products in the  order of high to low price 
	
Scenario: Adding products to cart 
	Given I have a browser with sauceDemoPage and open products page 
	When I click on add to cart button 
	Then products should be added to the cart 
	
Scenario: Displaying ordered products 
	Given I have a browser with sauceDemoPage and open products page 
	When I click on cart symbol 
	Then ordered products should be displayed with product details 
	
Scenario: clicking on continue shopping 
	Given 	I have a browser with sauceDemoPage and open products page 
	When  I click on continue shopping  button 
	Then products page should be displayed 
	
Scenario: clicking on CheckOut 
	Given 	I have a browser with sauceDemoPage and open products page 
	When  I click on CheckOut button 
	Then information  page should be displayed 
	
Scenario: Entering your Information 
	Given 	I have a browser with sauceDemoPage and open products page 
	When  I enter firstName as 'nimmi' and lastname as 'jimmi' and zipCode as '522612' 
	Then overView  page should be displayed 
	
Scenario: Click on cancel after giving information 
	Given 	I have a browser with sauceDemoPage and open products page 
	When  I enter firstName as 'nimmi' and lastname as 'jimmi' and zipCode as '522612'  and click on cancel 
	Then ordered products should be displayed with product details 
	
Scenario: Placing an order 
	Given 	I have a browser with sauceDemoPage and open products page 
	When  I enter firstName as 'nimmi' and lastname as 'jimmi' and zipCode as '522612'  and click on continue and then finish 
	Then finish page should be opened 
	
Scenario: Successfully placed order message 
	Given 	I have a browser with sauceDemoPage and open products page 
	When  I enter firstName as 'nimmi' and lastname as 'jimmi' and zipCode as '522612'  and click on continue and then finish 
	Then thank you for order message should be displayed 
	
Scenario: Logout from the website
Given I have a browser with sauceDemoPage
When We click on open menu and click on logout
Then 
	

   