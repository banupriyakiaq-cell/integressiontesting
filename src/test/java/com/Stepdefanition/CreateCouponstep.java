package com.Stepdefanition;

import java.awt.color.CMMException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.DriverFactory.DriverFactory;
import com.Pages.Adminpage;
import com.Pages.CouponCreation;
import com.Pages.Login;
import com.Pages.merchantpage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class CreateCouponstep {
	private static String title;
	private String createdCouponName;
	private Login log;
	private CouponCreation cc;
	private Adminpage ap;
	private merchantpage mp;

	@Given("user is on home page click merchant option and enter {string} and {string} click verification button")
	public void user_is_on_home_page_click_merchant_option_and_enter_and_click_verification_button(String Mobilenumber,
			String Fullname) {
		log = new Login(DriverFactory.getDriver());
		cc = new CouponCreation(DriverFactory.getDriver());
		ap = new Adminpage(DriverFactory.getDriver());
		mp = new merchantpage(DriverFactory.getDriver());
		log.clickmerchantoption();
		log.entermplfield(Mobilenumber);
		log.enterusername(Fullname);
		log.clickpasscode();
	}

	@When("and enter {string} then click verify button its navigate to respective page")
	public void and_enter_then_click_verify_button_its_navigate_to_respective_page(String Password) {
		log.enterpassword(Password);
		log.clickverifybutton();
	}

	@When("click the promo coupon module and click create coupon")
	public void click_the_promo_coupon_module_and_click_create_coupon() {
		cc.clickpromocoupon();
		cc.clickcreatecouponbutton();
	}

	@When("enter {string} and {string} then enter {string} and {string} select course")
	public void enter_and_then_enter_and_select_course(String couponcode, String percentage, String promoheadline,
			String offerdetails) {
		createdCouponName = couponcode;
		cc.entercouponcode(couponcode);
		cc.enterpercentege(percentage);
		cc.enterpromoheadline(promoheadline);
		cc.enterofferfield(offerdetails);
		cc.selectprogram();
	}

	@When("verify created coupon is dispalyed and merchant shoild see the approved coupon")
	public void verify_created_coupon_is_dispalyed_and_merchant_shoild_see_the_approved_coupon() {
		mp = new merchantpage(DriverFactory.getDriver());
		Assert.assertTrue(mp.isCoupondispalyed(createdCouponName), "Create coupon is not displayed");
		String rowText = mp.getcouponcode(createdCouponName);
		Assert.assertFalse(rowText.isEmpty(), "Approved coupon is not displayed in merchant panel");

	}

	@Then("click submit button again click close button and closeicon")
	public void click_submit_button_again_click_close_button_and_closeicon() {
	     //cc.clicksubmitbutton();
		cc.clickcancelbutton();
		String status = mp.getcouponstatus();
		System.out.println("Coupon status in merchant panel:" + status);
		Assert.assertEquals(status.trim().toLowerCase(), "rejected", "Coupon rejection status mismatch");
		 
	}
	@Then("merchant click logout button")
	public void merchant_click_logout_button() {
		cc.clicklogoutbutton();
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());  
	}
//Admin
	@Given("admin is on home page  click  admin option and enter {string} and {string} click verification button")
	public void admin_is_on_home_page_click_admin_option_and_enter_and_click_verification_button(String Emailid,
			String password) {
		log = new Login(DriverFactory.getDriver());
		log.clickadminoption();
		log.enteremail(Emailid);
		log.enteradminpassword(password);
		log.clickauthenticatebutton();
	}

	@When("enter 2fa {string} and clik authorize buttton")
	public void enter_2fa_and_clik_authorize_buttton(String passcode) {
		log.enetrpasscode(passcode);
		log.clickauthorizebutton();
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("admin"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}

	@When("click coupon approval module select pending option and click approve button")
	public void click_coupon_approval_module_select_pending_option_and_click_approve_button() {
		ap = new Adminpage(DriverFactory.getDriver());
		ap.clickcouponapprovemodule();
		 ap.selectpendind();
		 ap.clickapprovebutton();
		ap.clickgrjectoption();
	}

	@When("admin search couponcode {string} and created coupon shold be displayed")
	public void admin_search_couponcode_and_created_coupon_shold_be_displayed(String couponcode) {
		ap.entersearchfield(couponcode);
		mp = new merchantpage(DriverFactory.getDriver());
		Assert.assertTrue(mp.isCoupondispalyed(couponcode), "Created coupon is not displayed");
	}

	@Then("click logout button")
	public void click_logout_button() {
		ap.clicklogoutbutton();
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}

	// learner
	@Given("learner is on home page and enter {string} and enter {string} and click passcode button")
	public void learner_is_on_home_page_and_enter_and_enter_and_click_passcode_button(String Mobilenumber,
			String Fullname) {
		log = new Login(DriverFactory.getDriver());
		log.enterlearnermblno(Mobilenumber);
		log.enterlearnerfullname(Fullname);
		log.clickverificaionbutton();
	}

	@When("and enter {string} and click verify button is navigate respective page")
	public void and_enter_and_click_verify_button_is_navigate_respective_page(String passcode) {
		log.enterlearnerpasscode(passcode);
		log.clicklearningspacebutton();

	}

	@When("and click offer option and learner should be see the approved coupon")
	public void and_click_offer_option_and_learner_should_be_see_the_approved_coupon() {
		cc = new CouponCreation(DriverFactory.getDriver());
		cc.clickofferoption();
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(cc.couponcod));
		String a = cc.couponcod.getText().trim();
		Assert.assertEquals(a, "ABPDSV1234");
 
		boolean displayed=cc.iscoupondisplayed();
		Assert.assertFalse(displayed,"Rejected coupon displayed in learner panel");

	}

	@Then("click profile button and click logout option")
	public void click_profile_button_and_click_logout_option() {
		cc.clickprofileicon();
		cc.clicksignoutoption();
	}

}
