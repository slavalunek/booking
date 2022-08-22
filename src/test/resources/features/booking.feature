Feature: booking search

  Scenario: Search for "hotel" in the booking catalog
    Given User is on "https://www.booking.com/searchresults.en-gb.html?auth_success=1" page
    And The browser is maximized
    When User searches for "Orbi City Hotel Batumi"
    And The Button clicked
    Then "Orbi City Hotel Batumi" is the first search result