Feature: integreseion testing
@merchant
  Scenario Outline: course creation
    Given user lanuch the application
    And merchant is on home page click the merchant module
    When merchant navigate to the respective page
    And merchant enter the mobile number "<Mobilenumber>"
    And merchant enter the full name "<Fullname>"
    And merchant click the passcode button
    And merchant enter the password "<Password>"
    And merchant click the verify button
    And merchant click the course studio option
    And merchant click the new course program button
    And merchant enters course details for "<Coursetitle>" field
    And merchant select the category
    And merchant fix the course tution fee in "<Tuitionfee>" field
    And merchant fix the course duration time "<Programduration>" field
    And merchant select the delivery format
    Then merchant "<Notes>" give overview of course details
    And merchant click the add module button
    When merchant give module title "<ModuleTitle>"
    And merchant enter dureation time "<ModuleDuration1>"
    And merchant enter the description "<ModuleDescription1>"
    When merchant give another module title "<ModuleTitle2>"
    And merchant enter another duration time "<ModuleDuration2>"
    And merchant enter another the description "<ModuleDescription2>"
    And merchant click the publish course button
    And merchant click the close button
    And merchant click the close icon
    Then merchant click the merchant logout button

    Examples:
      | Mobilenumber | Fullname               | Password | Coursetitle   | Tuitionfee | Programduration | ModuleTitle  | ModuleDuration1 | ModuleDescription1 | ModuleTitle2 | ModuleDuration2 | Module Description2 |
      | 9876543210   | Apex Institute Manager | 123456   | TeleMarketing | 2500       | 1 Month         | Foundation 1 | 15 days         | valid points added | Foundation 2 | 15 days         | All topic           |
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
|EmailId|Password|passcode|
|admin@corzaar.com|Admin@123|123456|