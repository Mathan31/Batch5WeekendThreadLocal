package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class LoginPage extends BaseClass{
	
	private By oUsername = By.id("username");
	private By oPassword = By.id("password");
	private By oSignIn = By.xpath("//button[text()='Sign In']");
	private By oRegister = By.xpath("//*[text()='Register For Account']");
		
	public boolean verifyElement() {
		if(verifyDisplayedwithReturn(getDriver().findElement(oUsername))&& verifyDisplayedwithReturn(getDriver().findElement(oPassword))
				&& verifyDisplayedwithReturn(getDriver().findElement(oSignIn))&& verifyDisplayedwithReturn(getDriver().findElement(oRegister))) {
			return true;		
		}else {
			return false;
		} 
	}
	
	public LoginPage typeUserName(String userName) {
		type(getDriver().findElement(oUsername),userName);
		return this;
	}
	
	public LoginPage typePassword(String password) {
		type(getDriver().findElement(oPassword),password);
		return this;
	}
	
	public HomePage clickSignIn() {
		click(getDriver().findElement(oSignIn));
		return new HomePage();
	}
	
	public LoginPage clickSignInFailed() {
		click(getDriver().findElement(oSignIn));
		return this;
	}
	
	public RegistrationPage clickRegister() {
		click(getDriver().findElement(oRegister));
		return new RegistrationPage();
	}

}
