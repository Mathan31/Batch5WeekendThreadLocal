package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@BeforeTest
	public void testCasesetUp() {
		sExcelName = "TC001";
		authors = "Gopal";
		category = "Smoke";
		testCaseName = "Login";
		testDescription = "Testing all the Login Functionality!!";
		module = "Login Module";
	}
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage().verifyElement();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2,dataProvider = "TestCaseData")
	public void loginWithValidCredential(String uName,String password) {
		new LoginPage()
			.typeUserName(uName)
			.typePassword(password)
			.clickSignIn()
			.validateHomePage()
			.clickonLogout();
	} 
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage()
		.typeUserName("mathan")
		.typePassword("test123")
		.clickSignInFailed()
		.verifyElement();
		Assert.assertTrue(result);
	}

}
