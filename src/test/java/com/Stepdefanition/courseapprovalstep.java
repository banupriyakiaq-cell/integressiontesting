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
	@Given("user lanuch the application merchant click the merchant module is navigate to respective page.")
	public void user_lanuch_the_application_merchant_click_the_merchant_module_is_navigate_to_respective_page() {
		log = new Login(DriverFactory.getDriver());
		mp = new merchantpage(DriverFactory.getDriver());
		ap = new Adminpage(DriverFactory.getDriver());
		log.clickmerchantoption();
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("merchant"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}

	@When("merchant enter the mobile number {string} and name {string}")
	public void merchant_enter_the_mobile_number_and_name(String Mobilenumber, String Fullname) {
		log.entermplfield(Mobilenumber);
		log.enterusername(Fullname);
	}

	@When("merchant click the passcode button and enter the {string} and click verify button")
	public void merchant_click_the_passcode_button_and_enter_the_and_click_verify_button(String Password) {
		log.clickpasscode();
		log.enterpassword(Password);
		log.clickverifybutton();
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("merchant"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
	}

	@When("its navigate to merchant page and click course studio and click new course program button")
	public void its_navigate_to_merchant_page_and_click_course_studio_and_click_new_course_program_button() {
		mp.clickcoursestudio();
		mp.clicknewcourseprogram();
	}

	@When("merchant enters course details for {string} field and select the category")
	public void merchant_enters_course_details_for_field_and_select_the_category(String Coursetitle) {
		mp.entercoursedetails(Coursetitle);
		mp.selectcategory();
	}

	@When("merchant fix the course tution fee in {string} and fix the course duration time {string} field")
	public void merchant_fix_the_course_tution_fee_in_and_fix_the_course_duration_time_field(String Tuitionfee, String Programduration) {
		mp.enteramount(Tuitionfee);
		mp.enterprogramduration(Programduration);
	}

	@When("merchant select the delivery format and {string} give overview of course details")
	public void merchant_select_the_delivery_format_and_give_overview_of_course_details(String Notes) {
		mp.selectdeliveryformat();
		mp.enternotesfield(Notes);
	}

	@When("merchant click the add module button and  give module title {string} and  time {string} duration description {string}")
	public void merchant_click_the_add_module_button_and_give_module_title_and_time_duration_description(String ModuleTitle, String ModuleDuration1, String ModuleDescription1) {
		mp.clickaddmodulebutton();
		mp.entermoduletitle(ModuleTitle);
		mp.enterdurationdetails(ModuleDuration1);
		mp.entermoduldescription(ModuleDescription1);
	}

	@When("merchant give another module title {string},duration time {string},description {string}")
	public void merchant_give_another_module_title_duration_time_description(String ModuleTitle2, String ModuleDescription2, String ModuleDuration2) {
		mp.entersecondmoduletitle(ModuleTitle2);
		mp.enterseconddurationdetails(ModuleDescription2);
		mp.entersecondmoduldescription(ModuleDuration2);

	}

	@When("merchant click the publish course button again click the close button and close icon")
	public void merchant_click_the_publish_course_button_again_click_the_close_button_and_close_icon() {
		mp.clickpubliccoursebutton();
		mp.clicknewcourseprogram();
		mp.clickclosebutton();
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
