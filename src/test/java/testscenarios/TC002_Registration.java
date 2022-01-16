package testscenarios;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.RegistrationPage;

public class TC002_Registration extends BaseClass{
	
	@BeforeTest
	public void testCasesetUp() {
		sExcelName = "TC002";
		authors = "Saran";
		category = "Sanity";
		testCaseName = "Registration";
		testDescription = "Testing all the Register Functionality";
		module = "Register Module";
	}
	
	
	@Test(priority = 1)
	public void registrationFieldValidation() {
		boolean result = new LoginPage()
		.clickRegister()
		.fieldValidation();
		Assert.assertTrue(result);
		new RegistrationPage().clickLogin();
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void registerWithMandatoryField(String fName,String lName,String uName,String email,String password) {
		new LoginPage()
		.clickRegister()
		.enterFirstName(fName)
		.selectTitle("Mr")
		.enterMiddleName()
		.enterLastName(lName)
		.selectGender("Male")
		.enterUserName(uName+generateRandomInt(100, 100000))
		.enterEmail(email+generateRandomInt(100, 100000)+"@gmail.com")
		.enterPassword(password)
		.clickRegisterLink()
		.verifyUserRegistration()
		.clickOnLogin();
		 
	} 
	
	public int generateRandomInt(int min,int max) {
		Random r = new Random();
		int result = r.nextInt((max-min)+1)+min;
		return result;
	}

}
