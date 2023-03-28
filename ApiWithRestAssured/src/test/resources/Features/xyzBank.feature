Feature: Bank Manager Login

  @addCustomer

  Scenario Outline: Manager adds a customer
    Given Manager lands on XYZ bank home page
#    And clicks on bank manager login option
#    And clicks on add customer tab
    When Manager sends customers '<firstName>' '<lastName>' and '<postCode>'
    And clicks on add customer button
    Then Manager closes confirmation alert for customer creation
    Examples:
      | firstName | lastName | postCode |
      | john      | test     | 1330     |


  @openAccount
  Scenario: Manager opens an account by linking newly created customer
    Given Manager clicks on the open account tab
    When Manager selects customer name
    And selects currency type
    And clicks on process button
    Then Manager closes confirmation alert for account creation