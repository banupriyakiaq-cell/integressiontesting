package com.Utilities;

public class ConstantUtils {

	public static final int IMPLICIT_WAIT_TIME = 10;

	public static final int EXPLICIT_WAIT_TIME = 10;

	public static final int PAGE_LOAD_TIME = 20;

	public static final String EMAILID = ConfigReader.getProperty("validmailid");

	public static final String PASSWORD = ConfigReader.getProperty("validpassword");
	
	public static final String  OTP = ConfigReader.getProperty("validotp");

	 //learner
	 public static final String LEARNER_MOBILE =ConfigReader.getProperty("learner.userMobileNumber");
	 public static final String LEARNER_NAME =ConfigReader.getProperty("learner.userName");
	 public static final String LEARNER_OTP = ConfigReader.getProperty("learner.Otp");
	 
	 //Admin
	 public static final String ADMIN_EMAIL    =ConfigReader.getProperty("Admin.Emailid");
	 public static final String ADMIN_PASSWORD  =ConfigReader.getProperty("Admin.Password");
	 public static final String ADMIN_OTP = ConfigReader.getProperty("Admin.Otp");
	 
	 //Merchant
	 public static final String  MERCHANT_MOBILE =ConfigReader.getProperty("Merchant.MobileNumber");
	 public static final String MERCHANT_NAME =ConfigReader.getProperty("Merchant.Name");
	 public static final String MERCHANT_OTP = ConfigReader.getProperty("Merchant.Otp");
	 
}
 
