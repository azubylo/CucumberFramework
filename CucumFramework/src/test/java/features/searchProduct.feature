Feature: Search and Place the order for Products

Scenario: Search Experience for product search in both home and Offers page

Given User is on GreenCart Landing Page
When User searches with Shortname "Tom" and extracts actual name of product
Then User searches for "Tom" shortname in offers page 
And Validate product name in offers page matches with Landing Page
