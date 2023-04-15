#Receving
Feature: Feature to Test the Receving process in WMS.

Scenario Outline: To check Conversion ASN receiving is successful
  
  	Given the user navigates to WMS Login Page
  	When the user needs to enter the username and password
  	Then user is taken to WMS homepage
  	When user searches RF menu in WMS and selects inbound transaction
  	Then user selects Receive Conversion
  	And the user will enter the ASN
  	Then the user enters the batch and location
  	Then the user opens ASN menu and verify the asn
  	And the ASN is verified
  	




