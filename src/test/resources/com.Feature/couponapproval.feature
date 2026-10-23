Feature: integresion testing

  @Merchant
  Scenario Outline: coupon creation
    Given user is on home page click merchant option and enter "<Mobilenumber>" and "<Fullname>" click verification button
    When and enter "<Password>" then click verify button its navigate to respective page
    And click the promo coupon module and click create coupon
    And enter "<couponcode>" and "<percentage>" then enter "<promoheadline>" and "<offerdetails>" select course
    And verify created coupon is dispalyed and merchant shoild see the approved coupon
    Then click submit button again click close button and closeicon
    Then merchant click logout button

    Examples:
      | Mobilenumber | Fullname               | Password | couponcode | percentage | promoheadline | offerdetails     |
      | 9876543210   | Apex Institute Manager | 123456   | ABPDSV1234 | 25         | Year end      | Eligible For All |

  @admin
  Scenario Outline: coupon approval
    Given admin is on home page  click  admin option and enter "<Emailid>" and "<password>" click verification button
    When enter 2fa "<passcode>" and clik authorize buttton
    And click coupon approval module select pending option and click approve button
    And admin search couponcode "<couponcode>" and created coupon shold be displayed
    Then click logout button

    Examples:
      | Emailid           | password  | passcode | couponcode |
      | admin@corzaar.com | Admin@123 | 123456   | ABPDSV1234 |

  @learner
  Scenario Outline: verify coupon display
    Given learner is on home page and enter "<Mobilenumber>" and enter "<Fullname>" and click passcode button
    When and enter "<passcode>" and click verify button is navigate respective page
    And and click offer option and learner should be see the approved coupon
    Then click profile button and click logout option

    Examples:
      | Mobilenumber | Fullname     | passcode |
      | 9876543210   | Rahul Sharma | 123456   |
