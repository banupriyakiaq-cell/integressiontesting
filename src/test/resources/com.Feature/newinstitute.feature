Feature: integration testing

  @merchant
  Scenario Outline: New institute approval
    Given new merchant enter mobile number "<MblNumber>" enter institute name "<InstituteName>"
    When click passcode button and enter "<Password>" and click the verify button
    Then verify the institute is approval are not and click the logout button

    Examples:
      | MblNumber  | InstituteName  | Password |
      | 8220004848 | VSP institute  | 123456   |
      | 9090909898 | Arun institute | 123456   |

  @admin
  Scenario Outline: approved new institute
    Given admin enter the email id "<Emailid>" and "<Pasword>" click the authenticate button and enter "<passcode>" click verify button
    When admin click institute moderation and click pending option
    Then admin click the approve button and click the reject button

    Examples:
      | Emailid           | Pasword   | passcode |
      | admin@corzaar.com | Admin@123 | 123456   |

  @verify
  Scenario: insiute approved verify
    Given verify the institutes reject status in merchant panel "8220004848" ane "VSP institute" and click the passcode button
    When click the passcode button and enter "123456" and click the verify button
    And verify the institutes approval status in merchant panel "9090909898" ane " Arun institute " and click the passcode button
    And again click the passcode button and enter "123456" and click the verify button
    Then logout the merchant panel
