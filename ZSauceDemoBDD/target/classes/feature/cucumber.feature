Feature: SauceDemoPage 
	In order to order a product in Saucedemo page
    As a e-commerce vendor
    I want to get access to the portal
    

Background: these are the steps common for every scenario to be followed
Given I have a browser with sauceDemoPage 

Scenario Outline: Login with ValidCredentials 
	When I enter userName as '<userName>' and I enter password as  '<password>' 
	Then I should access to the portal 
	Examples: 
		|userName|password|
		|standard_user|secret_sauce|
		
Scenario: Adding products to cart 
	When I click on add to cart button by entering userName as 'standard_user' and password as  'secret_sauce' 
	Then products should be added to the cart 
	
Scenario: Displaying ordered products 
	When I click on cart symbol by entering userName as 'standard_user' and password as  'secret_sauce' 
	Then ordered products should be displayed with product details 
	
Scenario: clicking on continue shopping 
	When  I click on continue shopping  button by entering userName as 'standard_user' and password as  'secret_sauce'  
	Then products page should be displayed 
	
Scenario: clicking on CheckOut 
	When  I click on CheckOut button by entering userName as 'standard_user' and password as  'secret_sauce'  
	Then information  page should be displayed 
	
Scenario: Entering your Information 
	When  I enter userName as 'standard_user' and password as  'secret_sauce'  and firstName as 'nimmi' and lastname as 'jimmi' and zipCode as '522612' 
	Then overView  page should be displayed 
	
Scenario: Placing an order 
	When  I enter userName as 'standard_user' and password as  'secret_sauce' and firstName as 'nimmi' and lastname as 'jimmi' and zipCode as '522612'  and click on continue and then finish 
	Then finish page should be opened 
	
Scenario: Successfully placed order message 
	When  I enter userName as 'standard_user' and password as  'secret_sauce' and firstName as 'nimmi' and lastname as 'jimmi' and zipCode as '522612'  and click on continue and then finish 
	Then thank you for order message should be displayed 
	
	

   