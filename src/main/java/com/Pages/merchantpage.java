package com.Pages;

import java.sql.RowId;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Utilities.ElementUtils;

public class merchantpage {

	private final WebDriver driver;
	private ElementUtils elementUtils;

	public merchantpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//a[.//span[normalize-space()='Course Studio']]")
	public WebElement coursestudiobutton;

	@FindBy(xpath = "//*[text()='New Course Program']")
	public WebElement newcoursebutton;

	@FindBy(id = "course-title")
	public WebElement coursetitlefield;

	@FindBy(xpath = "//select[@id='discipline-/-category']")
	public WebElement category;

	@FindBy(id = "tuition-fee-(₹)")
	public WebElement amountfield;

	@FindBy(id = "program-duration")
	public WebElement durationfield;

	@FindBy(xpath = "//select[@id='delivery-format']")
	public WebElement deliveryformat;

	@FindBy(id = "course-overview-&-learning-outcomes")
	public WebElement notesfield;

	@FindBy(xpath = "//*[text()='Add Module']")
	public WebElement addmodul;

	@FindBy(id = "module-1-title")
	public WebElement moduletitle;

	@FindBy(xpath = "(//input[@id='module-duration'])[1]")
	public WebElement moduleduration;

	@FindBy(xpath = "(//textarea[@id='module-description'])[1]")
	public WebElement moduledescription;

	@FindBy(id = "module-2-title")
	public WebElement moduletitlle2;

	@FindBy(xpath = "(//input[@id='module-duration'])[2]")
	public WebElement moduleduration2;

	@FindBy(xpath = "(//textarea[@id='module-description'])[2]")
	public WebElement moduledescription2;

	@FindBy(xpath = "//*[text()='Publish Course']")
	public WebElement publiccoursebutton;

	@FindBy(xpath = "//*[text()='Cancel']")
	public WebElement cancelbutton;

	@FindBy(xpath = "//*[@class='lucide lucide-x w-5 h-5']")
	public WebElement closeicon;

	@FindBy(xpath = "//button[.//*[name()='svg' and contains(@class,'lucide-log-out')]]")
	public WebElement logoutbutton;

	@FindBy(xpath = " //table/tbody/tr")
	public List<WebElement> couponrow;

	@FindBy(xpath = " //table//tr[1]//td[3]")
	public WebElement couponstatus;

	public void clickcoursestudio() {
		elementUtils.clickElement(coursestudiobutton);
	}

	public void clicknewcourseprogram() {
		elementUtils.clickElement(newcoursebutton);
	}

	public void entercoursedetails(String Coursetitle) {
		elementUtils.sendKeys(coursetitlefield, Coursetitle);
	}

	public void selectcategory() {
		elementUtils.dropdownValue(category, "Business");
	}

	public void enteramount(String Tuitionfee) {
		elementUtils.sendKeys(amountfield, Tuitionfee);
	}

	public void enterprogramduration(String Programduration) {
		elementUtils.sendKeys(durationfield, Programduration);
	}

	public void selectdeliveryformat() {
		elementUtils.dropDown(deliveryformat, "Hybrid");
	}

	public void enternotesfield(String Notes) {
		elementUtils.sendKeys(notesfield, Notes);
	}

	public void clickaddmodulebutton() {
		elementUtils.clickElement(addmodul);
	}

	public void entermoduletitle(String ModuleTitle) {
		elementUtils.sendKeys(moduletitle, ModuleTitle);
	}

	public void enterdurationdetails(String ModuleDuration1) {
		elementUtils.sendKeys(moduleduration, ModuleDuration1);
	}

	public void entermoduldescription(String ModuleDescription1) {
		elementUtils.sendKeys(moduledescription, ModuleDescription1);
	}

	public void entersecondmoduletitle(String ModuleTitle2) {
		elementUtils.sendKeys(moduletitle, ModuleTitle2);
	}

	public void enterseconddurationdetails(String ModuleDuration2) {
		elementUtils.sendKeys(moduleduration, ModuleDuration2);
	}

	public void entersecondmoduldescription(String ModuleDescription2) {
		elementUtils.sendKeys(moduledescription, ModuleDescription2);
	}

	public void clickpubliccoursebutton() {
		elementUtils.clickElement(publiccoursebutton);
	}

	public void clickclosebutton() {
		elementUtils.clickElement(cancelbutton);
	}

	public void clickcloseicon() {
		elementUtils.clickElement(closeicon);
	}

	public void clicklogoutbutton() {
		elementUtils.scrollAndClick(logoutbutton);
	}

	public boolean isCoupondispalyed(String couponName) {
		return couponrow.stream().anyMatch(row -> row.getText().contains(couponName));
	}

	public String getcouponcode(String couponCode) {
		return couponrow.stream().filter(row -> row.getText().contains(couponCode)).map(WebElement::getText).findFirst()
				.orElse("");
	}
	public String getcouponstatus() {
		return elementUtils.waitForVisibilityOfElement(couponstatus).getText().trim();
	}
}
