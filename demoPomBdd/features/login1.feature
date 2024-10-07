Feature: Test login 

  Scenario: Positive login test
    Given user is on login page
    When user logs in using credentials from Excel file "src/test/resources/credentials.xlsx" and sheet "LoginDetails"
    And clicks Submit button
    Then Verify the url of logged in page
    And Verify the message printed on login page
