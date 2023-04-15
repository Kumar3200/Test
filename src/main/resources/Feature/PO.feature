#Receving
Feature: Feature to Test the Receving process in WMS.
Scenario Outline: To check receiving asn created from PO is successful

Given the user is able to login the WMS application sucessful with user id and password
When the user search for Create ASN from PO menu and select it
Then the user paste the po and search it
When the user  click on  Generate ASN and select the date of delivery and click ok
Then the genrated ASN will be on the screen
When the user click on check box for both ASN and PO and clicks on the arrow facing right side and clicks on save
Then the asn will be in transit 
When the user search for RF menu and select it
Then the user select the Inbound option
And the user select the Receive Item lvl menu
And the user enters the ASN number
When the user enter the PO
Then the user enter the Business Partner
Then the ilpn and control number is generated and item and quantity entered
Then Qty is confirmed and Asn moves to Receiving started
And the user clicks on verify ASN
Then the ASN is now in receiving verified status
Then user have to select Ptwy User Dir
And the user will have to enter iLpn and location
And the putaway has been done