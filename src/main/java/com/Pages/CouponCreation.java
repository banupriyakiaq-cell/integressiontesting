package com.Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.DriverFactory.DriverFactory;
import com.Utilities.ElementUtils;

public class CouponCreation {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public CouponCreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
    @FindBy(xpath = "//*[text()='Coupons & Promos']")
	public WebElement couponpromo;

	@FindBy(xpath = "//*[text()='Create Coupon']")
	public WebElement createcouponbutton;

	@FindBy(id = "coupon-code")
	public WebElement couponcodefield;

	@FindBy(id = "discount-percentage-(%)")
	public WebElement percentag;

	@FindBy(id = "promotion-headline")
	public WebElement promoheadlinefield;

	@FindBy(id = "offer-details-/-eligibility")
	public WebElement offerdetailsfield;

	@FindBy(xpath = "//select[@id='restrict-to-course-(optional)']")
	public WebElement optionaldropdown;

	@FindBy(xpath = "//*[text()='Submit for Approval']")
	public WebElement submitbutton;

	@FindBy(xpath = "//*[text()='Cancel']")
	public WebElement cancelbutton;

	@FindBy(xpath = "//*[@class='lucide lucide-x w-5 h-5']")
	public WebElement cancelicon;
	
	@FindBy(xpath = "//button[.//*[name()='svg' and contains(@class,'lucide-log-out')]]")
	public WebElement logoutbutton;
	
	//learner
	
	@FindBy(xpath="//a[text()='Offers']")
	public WebElement offeroption;
	
	@FindBy(xpath = " //*[@class='flex items-center gap-2 p-1 rounded-full hover:ring-2 hover:ring-brand/20 transition-all']")
	public WebElement profilicon;
	
	@FindBy(xpath = " //*[text()='Sign Out']")
	public WebElement signoutopion;
	
	@FindBy(xpath = "(//div[normalize-space()='ABPDSV1234'])[1]")
	public WebElement couponcod;
	
	@FindBy(xpath="(//div[normalize-space()='ABPDSV1234'])[1]")
	public List<WebElement> couponcodedisplay;
	
	public void clickpromocoupon() {
		elementUtils.clickElement(couponpromo);
	}
    public void clickcreatecouponbutton() {
		elementUtils.clickElement(createcouponbutton);
	}
    public void entercouponcode(String couponcode) {
		elementUtils.sendKeys(couponcodefield, couponcode);
	}
    public void enterpercentege(String percentage) {
    	elementUtils.sendKeys(percentag, percentage);
    }
    public void enterpromoheadline(String promoheadline) {
    	elementUtils.sendKeys(promoheadlinefield, promoheadline);
    }
    public void enterofferfield(String offerdetails) {
    	elementUtils.sendKeys(offerdetailsfield,offerdetails);
    }
    public void selectprogram() {
    	elementUtils.dropDown(optionaldropdown, "All My Published Programs");
    }
    public void clicksubmitbutton() {
    	elementUtils.clickElement(submitbutton);
    }
    public void clickcancelbutton() {
    	elementUtils.clickElement(cancelbutton);
    }
    public void clickcancelicon() {
    	elementUtils.clickElement(cancelicon);
    }
    public void clicklogoutbutton() {
    	 elementUtils.waitForVisibilityOfElement(logoutbutton).click(); 	 
    }
  //learner
    public void  clickofferoption() {
		elementUtils.clickElement(offeroption);
	}
    public void  clickprofileicon() {
		elementUtils.clickElement(profilicon);
	}
    public void  clicksignoutoption() {
		elementUtils.clickElement(signoutopion);
	}
    public  void verifycoupon() {
    	elementUtils.getText(couponcod);
    }
    public boolean iscoupondisplayed() {
    return  couponcodedisplay.size()>0;
    }
}