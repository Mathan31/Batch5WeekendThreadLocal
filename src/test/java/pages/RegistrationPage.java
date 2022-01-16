package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class RegistrationPage extends BaseClass{
	
	private By oFirstName = By.id("firstName");
	private By oMiddleName = By.id("middleName");
	private By oLastName = By.id("lastName");
	private By oUserName = By.id("username");
	private By oEmail = By.id("email");
	private By oPassword = By.id("password");
	private By oRegister = By.xpath("//button[text()='Register']");
	private By oTitle = By.id("title");
	private By oGender = By.id("sex");
	private By oUILogo = By.xpath("//a[@class='navbar-brand']");
	private By oLogin = By.xpath("//a[text()='Login']");
	
	public boolean fieldValidation() {
		if(verifyDisplayedwithReturn(getDriver().findElement(oUserName)) && verifyDisplayedwithReturn(getDriver().findElement(oPassword))
				&& verifyDisplayedwithReturn(getDriver().findElement(oEmail))&& verifyDisplayedwithReturn(getDriver().findElement(oRegister))) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public LoginPage clickUILogo() {
		click(getDriver().findElement(oUILogo));
		return new LoginPage();
	}
	
	public LoginPage clickLogin() {
		click(getDriver().findElement(oLogin));
		return new LoginPage();
	}
	
	
	public RegistrationPage enterFirstName(String firstName) {
		type(getDriver().findElement(oFirstName), firstName);
		return this;
	}
	
	public RegistrationPage selectTitle(String title) {
		selectDropDownUsingVisibleText(getDriver().findElement(oTitle), title);
		return this;
	}
	
	public RegistrationPage enterMiddleName() {
		type(getDriver().findElement(oMiddleName), "");
		return this;
	}
	
	public RegistrationPage enterLastName(String lastName) {
		type(getDriver().findElement(oLastName),lastName);
		return this;
	}
	
	public RegistrationPage selectGender(String gender) {
		selectDropDownUsingVisibleText(getDriver().findElement(oGender), gender);
		return this;
	}
	
	public RegistrationPage enterUserName(String userName) {
		type(getDriver().findElement(oUserName),userName);
		return this;
	}
	
	public RegistrationPage enterEmail(String email) {
		type(getDriver().findElement(oEmail),email);
		return this;
	}
	
	public RegistrationPage enterPassword(String password) {
		type(getDriver().findElement(oPassword),password);
		return this;
	}
	
	public EmailVerificationPage clickRegisterLink() {
		click(getDriver().findElement(oRegister));
		return new EmailVerificationPage();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
