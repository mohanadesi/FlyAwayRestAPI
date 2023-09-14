Feature: User Registration via REST API

  Scenario: Register a new user via REST API
    Given a user with the following registration details
      | Email      | test@example.com | 
      | Password  | secret|
      | ConfirmPassword | secret |
      |Name  |John  |
      | Address          |123 Main Street | 
      | City      |Anytown   |       
    When I send a POST request to the registration endpoint
    Then the registration should be successful
    And the response should contain the user details
