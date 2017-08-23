Feature: Manage customers

  Scenario: Some customers exist from the start
    When searching for all customers
    Then the following customers should always be present:
      | First Name | Last Name | Id |
      | Oliver     | Gierke    | 1  |
      | Andy       | Wilkinson | 2  |
      | Dave       | Syer      | 3  |
