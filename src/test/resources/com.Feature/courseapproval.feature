Feature: integreseion testing

  @merchant
  Scenario Outline: course creation
    Given user lanuch the application merchant click the merchant module is navigate to respective page.
    When merchant enter the mobile number "<Mobilenumber>" and name "<Fullname>"
    And merchant click the passcode button and enter the "<Password>" and click verify button
    And its navigate to merchant page and click course studio and click new course program button
    And merchant enters course details for "<Coursetitle>" field and select the category
    And merchant fix the course tution fee in "<Tuitionfee>" and fix the course duration time "<Programduration>" field
    And merchant select the delivery format and "<Notes>" give overview of course details
    And merchant click the add module button and  give module title "<ModuleTitle>" and  time "<ModuleDuration1>" duration description "<ModuleDescription1>"
    When merchant give another module title "<ModuleTitle2>",duration time "<ModuleDuration2>",description "<ModuleDescription2>"
    And merchant click the publish course button again click the close button and close icon
    Then merchant click the merchant logout button

    Examples:
      | Mobilenumber | Fullname               | Password | Coursetitle   | Tuitionfee | Notes   | Programduration | ModuleTitle  | ModuleDuration1 | ModuleDescription1 | ModuleTitle2 | ModuleDuration2 | ModuleDescription2 |
      | 9876543210   | Apex Institute Manager | 123456   | TeleMarketing | 2500       | welcome | 1 Month         | Foundation 1 | 15 days         | Valid points added | Foundation 2 | 15 days         | All topic           |

  @Admin
  Scenario Outline: Admin approve the course
    Given admin in home page
    When admin click the admin module
    And admin enter the mail details in "<EmailId>"
    And admin enter the password in "<Password>" field
    And admin click the authentic button
    And admin enter the 2fa "<passcode>" in the field
    And admin navigate to respective page
    And admin click the course moduration module
    And admin select the filter option
    And it displayed the correct details

    Examples:
      | EmailId           | Password  | passcode |
      | admin@corzaar.com | Admin@123 | 123456   |
