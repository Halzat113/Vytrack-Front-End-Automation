@smoke
Feature: Login/out functionality for every user

    @test
    Scenario Outline: user login functionality
      Given I am on the "login" page
      When I enter "positive" datatype as "<user>"
      Then I am on the "main" page
      Examples: data are going to pass
        | user |
        | driver |
        | storemanager |
        | salesmanager |

    Scenario Outline: user logout functionality
      When I login as "<user>"
      When I click on "logout"
      Then I am on the "login" page
      Examples: data are going to pass
        | user |
        | driver |
        | storemanager |
        | salesmanager |
