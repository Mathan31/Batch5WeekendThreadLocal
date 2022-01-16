package libraries;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class HTMLReport {
	
	public static ExtentHtmlReporter html;
	public static ExtentReports extent;
	public ExtentTest test,node;
	public String authors,category;
	public static ThreadLocal<ExtentTest> tlNode = new ThreadLocal<ExtentTest>();
	
	public void startReport() {
		html = new ExtentHtmlReporter("./report/UIBankReport.html");
		extent = new ExtentReports();
		html.setAppendExisting(false);
		extent.attachReporter(html);
	}
	
	public ExtentTest getNode() {
		return tlNode.get();
	}
	
	public void endReport() {
		extent.flush();
	}
	
	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		test = extent.createTest(testCaseName, testDescription);
		test.assignAuthor(authors);
		test.assignCategory(category);
		return test;
	}

	public ExtentTest startTestcase(String nodes) {
		tlNode.set(test.createNode(nodes));
		return getNode();
	}
	
	public void reportStep(String desc,String status) {
		try {
		if(status.equalsIgnoreCase("pass")){
			getNode().pass(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());
			} else if(status.equalsIgnoreCase("fail")) {
				getNode().fail(desc, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot()).build());	
			} else {
				getNode().info(desc);	
			}
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public abstract String takeScreenshot();

}
