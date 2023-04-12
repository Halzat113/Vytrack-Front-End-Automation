Feature: As user I should be able view fleet module

  Background:
    Given I login as "driver"
    Then I am on the "main" page

  Scenario: driver can view all the vehicles on fleet module
    Given I click "vehicles" on "fleet menu"
    When I set page to 10
    Then I should get the correct result

  @run
  Scenario: truck driver is able to create vehicle odameter
    Given I click "vehicle odometer" on "fleet menu"
    And I navigate to "odometer creation" page
    When I fill out info
      | odometer value | 12000      |
      | date           | 2018-Jan-4 |
      | driver         | John       |

    Then I save the data