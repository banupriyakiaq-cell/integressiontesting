package com.Stepdefanition;

import java.lang.reflect.MalformedParameterizedTypeException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import com.DriverFactory.DriverFactory;
import com.Pages.Adminpage;
import com.Pages.Login;
import com.Pages.merchantpage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class courseapprovalstep {
	private static String title;
	private Login log;
	private merchantpage mp;
	private Adminpage ap;

	@Given("user lanuch the application")
	public void user_lanuch_the_application() {
		log = new Login(DriverFactory.getDriver());
		mp = new merchantpage(DriverFactory.getDriver());
		ap = new Adminpage(DriverFactory.getDriver());
	}

	@And("merchant is on home page click the merchant module")
	public void merchant_is_on_home_page_click_the_merchant_module() {
		log.clicklearneroption();
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("merchant"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}

	@When("merchant enter the mobile number {string}")
	public void merchant_enter_the_mobile_number(String Mobilenumber) {
		log.entermplfield(Mobilenumber);
	}

	@When("merchant enter the full name {string}")
	public void merchant_enter_the_full_name(String Fullname) {
		log.enterusername(Fullname);
	}

	@When("merchant click the passcode button")
	public void merchant_click_the_passcode_button() {
		log.clickpasscode();
	}

	@When("merchant enter the password {string}")
	public void merchant_enter_the_password(String Password) {
		log.enterpassword(Password);
	}

	@When("merchant click the verify button")
	public void merchant_click_the_verify_button() {
		log.clickverifybutton();
	}

	@When("merchant navigate to the respective page")
	public void merchant_navigate_to_the_respective_page() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("merchant"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}

	@When("merchant click the course studio option")
	public void merchant_click_the_course_studio_option() {
		mp.clickcoursestudio();
	}

	@When("merchant click the new course program button")
	public void merchant_click_the_new_course_program_button() {
		mp.clicknewcourseprogram();
	}

	@When("merchant enters course details for {string} field")
	public void merchant_enters_course_details_for_field(String Coursetitle) {
		mp.entercoursedetails(Coursetitle);
	}

	@When("merchant select the category")
	public void merchant_select_the_category() {
		mp.selectcategory();
	}

	@When("merchant fix the course tution fee in {string} field")
	public void merchant_fix_the_course_tution_fee_in_field(String Tuitionfee) {
		mp.enteramount(Tuitionfee);
	}

	@When("merchant fix the course duration time {string} field")
	public void merchant_fix_the_course_duration_time_field(String Programduration) {
		mp.enterprogramduration(Programduration);

	}

	@When("merchant select the delivery format")
	public void merchant_select_the_delivery_format() {
		mp.selectdeliveryformat();
	}

	@Then("merchant {string} give overview of course details")
	public void merchant_give_overview_of_course_details(String Notes) {
		mp.enternotesfield(Notes);
	}

	@Then("merchant click the add module button")
	public void merchant_click_the_add_module_button() {
		mp.clickaddmodulebutton();
	}

	@When("merchant give module title {string}")
	public void merchant_give_module_title(String ModuleTitle) {
		mp.entermoduletitle(ModuleTitle);
	}

	@When("merchant enter dureation time {string}")
	public void merchant_enter_dureation_time(String ModuleDuration1) {
		mp.enterdurationdetails(ModuleDuration1);
	}

	@When("merchant enter the description {string}")
	public void merchant_enter_the_description(String ModuleDescription1) {
		mp.entermoduldescription(ModuleDescription1);
	}

	@When("merchant give another module title {string}")
	public void merchant_give_another_module_title(String ModuleTitle2) {
		mp.entersecondmoduletitle(ModuleTitle2);
	}

	@When("merchant enter another duration time {string}")
	public void merchant_enter_another_duration_time(String ModuleDescription2) {
		mp.enterseconddurationdetails(ModuleDescription2);
	}

	@When("merchant enter another the description {string}")
	public void merchant_enter_another_the_description(String ModuleDuration2) {
		mp.entersecondmoduldescription(ModuleDuration2);
	}

	@When("merchant click the publish course button")
	public void merchant_click_the_publish_course_button() {
		mp.clickpubliccoursebutton();
	}

	@When("merchant click the close button")
	public void merchant_click_the_close_button() {
		mp.clicknewcourseprogram();
		mp.clickclosebutton();
	}

	@When("merchant click the close icon")
	public void merchant_click_the_close_icon() {
		mp.clicknewcourseprogram();
		mp.clickcloseicon();
	}

	@Then("merchant click the merchant logout button")
	public void merchant_click_the_merchant_logout_button() {
		mp.clicklogoutbutton();
	}

	@Given("admin in home page")
	public void admin_in_home_page() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("login"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}

	@When("admin click the admin module")
	public void admin_click_the_admin_module() {
		log = new Login(DriverFactory.getDriver());
		log.clickadminoption();
	}

	@When("admin enter the mail details in {string}")
	public void admin_enter_the_mail_details_in(String EmailId) {
		log.enteremail(EmailId);
	}

	@When("admin enter the password in {string} field")
	public void admin_enter_the_password_in_field(String Password) {
		log.enteradminpassword(Password);
	}

	@When("admin click the authentic button")
	public void admin_click_the_authentic_button() {
		log.clickauthenticatebutton();
	}

	@When("admin enter the 2fa {string} in the field")
	public void admin_enter_the_2fa_in_the_field(String passcode) {
		log.enetrpasscode(passcode);
	}

	@When("admin navigate to respective page")
	public void admin_navigate_to_respective_page() {
		log.clickauthorizebutton();
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("admin"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}

	@When("admin click the course moduration module")
	public void admin_click_the_course_moduration_module() {
		ap=new Adminpage(DriverFactory.getDriver());
		ap.clickcoursemodurationmodul();
	}

	@When("admin select the filter option")
	public void admin_select_the_filter_option() {
      ap.selectunderreview();
	}

	@When("it displayed the correct details")
	public void it_displayed_the_correct_details() {

	}

}
