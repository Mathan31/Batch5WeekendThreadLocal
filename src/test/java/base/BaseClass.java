package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import libraries.SeleniumWrapper;
import utilities.ExcelReader;
import utilities.PropertiesReader;

public class BaseClass extends SeleniumWrapper {
	
	public WebDriver driver;
	public int iBrowserType = 1;
	public String sPropertyFile = "Environment_Details";
	public String sExcelName="";
	public String sURL = PropertiesReader.getPropertyValue(sPropertyFile, "production");
	public String testCaseName;
	public String testDescription;
	public String module;
	
	@BeforeSuite
	public void reportInit() {
		startReport();
	}
	
	@AfterSuite
	public void flushReport() {
		endReport();
	}
	
	@BeforeClass
	public void invokeBrowser() {
		switch (iBrowserType) {
		case 1:
			System.out.println("User Option is "+iBrowserType+", So invoking Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		
		case 2:
			System.out.println("User Option is "+iBrowserType+", So invoking FireFox Browser");
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
			
		case 3:
			System.out.println("User Option is "+iBrowserType+", So invoking Edge Browser");
			System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("User Option is wrong "+iBrowserType+", So invoking the default Chrome Browser");
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		tlDriver.set(driver);
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(sURL);
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		startTestCase(testCaseName, testDescription);
		startTestcase(module);
	}
	
	@AfterClass
	public void closeBrowser() {
		getDriver().quit();
	}
	
	@DataProvider(name="TestCaseData")
	public Object[][] getExcelData() {
		Object[][] data = ExcelReader.getValueFromExcel(sExcelName);
		return data;
	}

	
}
