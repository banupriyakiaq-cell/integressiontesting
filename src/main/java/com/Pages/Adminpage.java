package com.Pages;

import java.security.PublicKey;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.ElementUtils;

public class Adminpage {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public Adminpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "(//*[text()='Courses Moderation'])[1]")
	public WebElement coursesmoderationmodul;

	@FindBy(xpath = " //select[option[@value='under_review']]")
	public WebElement underreviewmodul;
	
	@FindBy(xpath = "//*[text()='Coupons Approval']")
	public WebElement couponapprovalmodul;
	
	@FindBy(xpath = "//select[option[@value='pending']]")
	public WebElement publicoption;
	
	@FindBy(xpath = "  //*[@placeholder='Search coupon codes...']")
	public WebElement searchfield;
	
	@FindBy(xpath  ="//*[text()='Approve']")
	public WebElement approvebutton;
	
	@FindBy(xpath="//*[text()='Reject']")
	public WebElement rejectoption;
	
	@FindBy(xpath = " //*[@class='lucide lucide-log-out w-4 h-4']")
	public WebElement logoutbutton;

	public void clickcoursemodurationmodul() {
		elementUtils.clickElement(coursesmoderationmodul);
	}

	public void selectunderreview() {
		elementUtils.dropDown(underreviewmodul, "Under Review");
	}
	public void clickcouponapprovemodule() {
		elementUtils.clickElement(couponapprovalmodul);
	}
	public void selectpendind() {
		elementUtils.dropDown(publicoption,"Pending");
		
	}
	public void clickapprovebutton() {
		elementUtils.clickElement(approvebutton);
	}
	public void clicklogoutbutton() {
		elementUtils.clickElement(logoutbutton);
	}
	public void entersearchfield(String couponCode) {
		elementUtils.sendKeys(searchfield, couponCode);
	}
	public void clickgrjectoption() {
		elementUtils.clickElement(rejectoption);
	}
}
