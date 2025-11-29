Feature:  Computers

Background: Login

Given i open demowebshop homepage
Scenario: Verify user is able to order laptop product

When i search for product "laptop"
Then i should see "laptop" result
And i clicked product name
Then i should see the product page "laptop"
And i added "5" quantity
And clicked on add to cart button
And i mousehover to shooping cart hyperlink
And i clicked on go to cart button
And i verified the details of the product added 





