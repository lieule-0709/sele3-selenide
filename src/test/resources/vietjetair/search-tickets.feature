@search-tickets
Feature: Search tickets

  @TC01
  Scenario: Search and choose tickets on a specific day successfully
    Given booking info:
      | flyType  | return      |
      | from     | Ho Chi Minh |
      | to       | Ha Noi      |
      | fromDate | 1           |
      | toDate   | 4           |
      | adults   | 1           |
    When I open vietjetair home page
    Then I fill the booking info