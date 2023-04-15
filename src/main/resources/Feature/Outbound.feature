#Outbound
Feature: Feature to Test the Outbound process in WMS
Scenario Outline: To check waving and packing for order is successful

Given By using username and password user can login into wms application
Then search for distribution order UI
And search for the specific order
Then wave the order
Then copy the olpn from order
And User will search for task in RF menu
Then user will enter the oLpn,ilpn and quantity and weight
And the order status will be moved to packed
