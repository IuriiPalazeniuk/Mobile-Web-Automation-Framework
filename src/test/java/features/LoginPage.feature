Feature: Checking the number of all friends

  @smoke
  Scenario: Log in to FaceBook and check count fo friends
    Given user enter credentials and tap on login
    When user switched to All friends page
    Then check results