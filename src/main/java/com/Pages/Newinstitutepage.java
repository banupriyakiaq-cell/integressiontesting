package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.ElementUtils;

public class Newinstitutepage {
	private final WebDriver driver;
	private ElementUtils elementUtils;

	public Newinstitutepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	// Admin
	@FindBy(xpath = "//*[text()='Merchant']")
	public WebElement merchantoption;

	@FindBy(id = "institute-manager-mobile-number")
	public WebElement institutemobilefield;

	@FindBy(id = "institute-contact-person-/-faculty-name")
	public WebElement institutenamefield;

	@FindBy(xpath = "//*[text()='Send Institute Verification Code']")
	public WebElement instituteverificationbutton;

	@FindBy(xpath = "//*[text()='Verify & Enter Merchant Studio']")
	public WebElement merchantbutton;

	@FindBy(id = "enter-6-digit-passcode")
	public WebElement passwordfield;
	
	@FindBy(xpath = "//button[.//*[name()='svg' and contains(@class,'lucide-log-out')]]")
	public WebElement logoutbutton;
	//admin
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
	
	@FindBy(xpath = "//*[text()='rejected']")
	public WebElement rejectstatus; 
	
	@FindBy(xpath = "//*[text()='approved']")
	public WebElement approvestatus;
	
	@FindBy(xpath = "//*[text()='Institutes Moderation']")
	public WebElement institutemoduration;
	
	@FindBy(xpath ="//select[option[@value='pending']]")
	public WebElement pendingoption;
	
	@FindBy(xpath = " (//*[text()='Approve'])[1]")
public WebElement approvebuttonElement;  
	
	@FindBy(xpath = " (//*[text()='Reject'])[1]")
	public WebElement rejectbuuton;
	
	@FindBy(xpath = "//*[@class='lucide lucide-log-out w-4 h-4']")
	public WebElement adminlogout;
	//merchant
	public void clickmerchantoption() {
		elementUtils.clickElement(merchantoption);
	}

	public void entermplfield(String Mobilenumber) {
		elementUtils.sendKeys(institutemobilefield, Mobilenumber);
	}

	public void enterusername(String Fullname) {
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
	public void clicklogoutbutton() {
		elementUtils.scrollAndClick(logoutbutton);
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
	public void clickinsitutemoduration() {
		elementUtils.clickElement(institutemoduration);
		
	}
	public void selectpending() {
		elementUtils.dropdownValue( pendingoption,"pending");
}
	public void clickapprovebutton()
	{
		elementUtils.clickElement(approvebuttonElement);
	}
	public void clickrejectbutton()
	{
		elementUtils.clickElement(rejectbuuton);
	}
	public String getrejectstatus() {
		return elementUtils.getText(rejectstatus);
	}
	public  String getapprovestatus() {
		 return elementUtils.getText(approvestatus);
   }
	public void clickadminlogout() {
		elementUtils.clickElement(adminlogout);
	}
}