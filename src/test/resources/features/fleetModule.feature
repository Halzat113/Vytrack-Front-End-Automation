Feature: As user I should be able view fleet module
  Background:
    Given I login as "driver"
    Then I am on the "main" page

    @wip
    Scenario: driver can view all the vehicles on fleet module
      Given I click "vehicles" on "fleet menu"
      When I set page to 10
      Then I should get the correct result
