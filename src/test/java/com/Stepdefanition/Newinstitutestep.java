package com.Stepdefanition;

import org.testng.Assert;

import com.DriverFactory.DriverFactory;
import com.Pages.Login;
import com.Pages.Newinstitutepage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Newinstitutestep {
	private Newinstitutepage np;

	@Given("new merchant enter mobile number {string} enter institute name {string}")
	public void new_merchant_enter_mobile_number_enter_institute_name(String MblNumber, String InstituteName) {
		np = new Newinstitutepage(DriverFactory.getDriver());
		np.clickmerchantoption();
		np.entermplfield(MblNumber);
		np.enterusername(InstituteName);

	}

	@When("click passcode button and enter {string} and click the verify button")
	public void click_passcode_button_and_enter_and_click_the_verify_button(String Password) {
		np.clickpasscode();
		np.enterpassword(Password);
		np.clickverifybutton();
	}

	@Then("verify the institute is approval are not and click the logout button")
	public void verify_the_institute_is_approval_are_not_and_click_the_logout_button() {
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("merchant"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());
		np.clicklogoutbutton();
	}

	@Given("admin enter the email id {string} and {string} click the authenticate button and enter {string} click verify button")
	public void admin_enter_the_email_id_and_click_the_authenticate_button_and_enter_click_verify_button(String Emailid,
			String Pasword, String passcode) {
		np = new Newinstitutepage(DriverFactory.getDriver());
		np.clickadminoption();
		np.enteremail(Emailid);
		np.enteradminpassword(Pasword);
		np.clickauthenticatebutton();
		np.enetrpasscode(passcode);
		np.clickauthorizebutton();
		Assert.assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("admin"));
		System.out.println(DriverFactory.getDriver().getCurrentUrl());

	}

	@When("admin click institute moderation and click pending option")
	public void admin_click_institute_moderation_and_click_pending_option() {
		np.clickinsitutemoduration();
        np.selectpending();
	}

	@Then("admin click the approve button and click the reject button")
	public void admin_click_the_approve_button_and_click_the_reject_button() {
		//np.clickapprovebutton();
		//np.clickrejectbutton();
		np.clickadminlogout();
	}

	@Then("verify the institutes reject status in merchant panel {string} ane {string} and click the passcode button")
	public void verify_the_institutes_reject_status_in_merchant_panel_ane_and_click_the_passcode_button(String MblNumber, String InstituteName)  {
		np = new Newinstitutepage(DriverFactory.getDriver());
		np.clickmerchantoption();
		np.entermplfield(MblNumber);
		np.enterusername(InstituteName);
	}

	@When("click the passcode button and enter {string} and click the verify button")
	public void click_the_passcode_button_and_enter_and_click_the_verify_button(String Password) {
		  		np.clickpasscode();
				np.enterpassword(Password);
				np.clickverifybutton();
				String status=np.getrejectstatus();
				System.out.println("InstituteStatus:"+status);
				Assert.assertEquals(status,"rejected", "Institute approval status is incorrect");	

				np.clicklogoutbutton();	}
	@When("verify the institutes approval status in merchant panel {string} ane {string} and click the passcode button")
	public void verify_the_institutes_approval_status_in_merchant_panel_ane_and_click_the_passcode_button(String MblNumber, String InstituteName) {
		np = new Newinstitutepage(DriverFactory.getDriver());
		np.clickmerchantoption();
		np.entermplfield(MblNumber);
		np.enterusername(InstituteName);
		
	}
	@When("again click the passcode button and enter {string} and click the verify button")
	public void again_click_the_passcode_button_and_enter_and_click_the_verify_button(String Password) {
		np.clickpasscode();
		np.enterpassword(Password);
		np.clickverifybutton();
		String status=np.getapprovestatus();
		System.out.println("InstituteStatus:"+status);
		Assert.assertEquals(status,"approved", "Institute approval status is incorrect");	
		}
	@Then("logout the merchant panel")
	public void logout_the_merchant_panel() {
		np.clicklogoutbutton();
	}

}
