Feature: Customer records
  Scenario: Remove a record from Customers
    Given Navigate to url
    When Click on the button “Bank Manager Login“
    And Click on the button “Customers“
    And Get the number of records in the table
    And Remove 1 of them
    Then Verify there are 3 records left