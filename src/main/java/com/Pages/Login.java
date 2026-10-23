package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.ElementUtils;

   

public class Login {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	//learner
	@FindBy(xpath = "//*[text()='Merchant']")
	public WebElement learneroption;
	
	@FindBy(id = "learner-mobile-number")
	public WebElement learnerMobilefield;
	
	@FindBy(id = "full-name-(optional-for-existing-learners)")
	public WebElement nameField;
	
	@FindBy(xpath = "//*[text()='Send One-Time Passcode']")
	public WebElement verificationbutton;
	
	@FindBy(id="enter-6-digit-passcode")
	public WebElement passwordfield;
	
	@FindBy(xpath = "//*[text()='Verify & Enter Learning Space']")
	public WebElement learningspacebutton;
	
	//merchant
	@FindBy(xpath = "//*[text()='Merchant']")
	public WebElement merchantoption;
	
	@FindBy(id = "institute-manager-mobile-number")
	public WebElement institutemobilefield;
	
	@FindBy(id="institute-contact-person-/-faculty-name")
	public WebElement institutenamefield;
	
	@FindBy(xpath = "//*[text()='Send Institute Verification Code']")
	public WebElement instituteverificationbutton;
	
	@FindBy(xpath = "//*[text()='Verify & Enter Merchant Studio']")
	public WebElement merchantbutton;
	
	//Admin
	@FindBy(xpath = " //*[text()='Admin']")
	public WebElement adminoption;
	
	@FindBy(id = "super-admin-email")
	public WebElement adminamailfield;
	
	@FindBy(xpath="//*[@type='password']")
	public WebElement adminpassswordfield;
	
	@FindBy(xpath = "//*[text()='Authenticate Super-Admin']")
	public WebElement authendicatebutton;
	
	@FindBy( id = "enter-admin-2fa-code")
	public WebElement adminotpfield;
	
	@FindBy(xpath = " //*[@type='submit']")
	public WebElement authorizebutton;
	
	//Merchant
	
	public void clickmerchantoption() {
		elementUtils.clickElement(merchantoption);
	}
	public void entermplfield(String Mobilenumber) {
		elementUtils.sendKeys(institutemobilefield, Mobilenumber);
		}
	public void enterusername(String Fullname ) {
		elementUtils.sendKeys(institutenamefield, Fullname);
	}
	public void clickpasscode() {
		elementUtils.scrollAndClick(instituteverificationbutton);
	}
	public void enterpassword(String Password) {
		elementUtils.sendKeys(passwordfield, Password);
	}
	public void clickverifybutton() {
		elementUtils.clickElement(merchantbutton);
	}
	
	public String getcurrentUrl() {
	return driver.getCurrentUrl();
}
	//admin
	
	public void clickadminoption() {
		elementUtils.clickElement(adminoption);
	}
	public void  enteremail(String EmailId) {
		elementUtils.sendKeys(adminamailfield, EmailId);
	}
	public void enteradminpassword(String Password) {
		elementUtils.sendKeys(adminpassswordfield, Password);
	} 
	public void  clickauthenticatebutton() {
		elementUtils. scrollAndClick(authendicatebutton);
	}
	public void enetrpasscode(String passcode) {
		elementUtils.sendKeys(adminotpfield, passcode);
	}
	public void clickauthorizebutton() {
		elementUtils.clickElement(authorizebutton);
	}
	//learner
	public void enterlearnermblno(String Mobilenumber ) {
		 elementUtils.sendKeys(learnerMobilefield, Mobilenumber);
	}
	public void enterlearnerfullname(String Fullname) {
		elementUtils.sendKeys( nameField, Fullname);
	}
	public void clickverificaionbutton() {
		elementUtils. scrollAndClick(verificationbutton);
	}
	public void enterlearnerpasscode(String passcode) {
		elementUtils.sendKeys( passwordfield, passcode);
	}
	public void clicklearningspacebutton() {
		elementUtils.clickElement(learningspacebutton);
	}
}
