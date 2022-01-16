package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import base.BaseClass;
import libraries.SeleniumWrapper;

public class EmailVerificationPage extends BaseClass{
	
	private By oWelcome = By.xpath("//*[text()=' Welcome To The UiBank Family! ']");
	private By oLogin = By.linkText("Login");
	
	
	public EmailVerificationPage verifyUserRegistration() {
		boolean displayed = verifyDisplayedwithReturn(getDriver().findElement(oWelcome));
		if(displayed) {
			System.out.println("User Registration is Successfull!!!");
		}else {
			System.out.println("User Registration is Not Successfull!!!");
		}
		return this;
	} 
	
	public LoginPage clickOnLogin() {
		click(getDriver().findElement(oLogin));
		return new LoginPage();
	}
	}

