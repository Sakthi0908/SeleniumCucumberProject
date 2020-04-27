Feature: Login Feature

@Regression
Scenario:TC_01: Login to Amazon Application
Given user is logged into amazon portal
Then verify home page is displayed

@Regression
Scenario Outline:TC_02: Searching product in Amazon
Given user is logged into amazon portal
Then verify home page is displayed
When user searches on product using "<TestData>" and "<TestDataSheet>"
Then verify that product page is displayed

Examples:
|TestData|TestDataSheet|
|TC_02|Amazon|