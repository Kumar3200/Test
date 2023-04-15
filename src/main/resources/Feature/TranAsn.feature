
Feature: Feature to Test the Receving process in WMS.

  Scenario Outline: To check receiving transfer asn is successful
    
    Given the user goes to WMS Login Page
    When the user enters the username and password
    Then user is in the WMS homepage
    When the user searches RF menu and selects the inbound
    Then the user  selects the Receive XO
    And the user selects the Receive ilpn ASN
    When the user enters the ASN
    And the user enters the ilpn
    Then the user verifies the ASN 
    And the status of ASN moves to receiveing verified
    Then user will select Ptwy User Dir
  	And the user will enter iLpn and location
  	And the putaway is done
  	




