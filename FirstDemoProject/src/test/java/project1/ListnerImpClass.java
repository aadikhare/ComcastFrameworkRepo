package project1;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webDriverUtility.UtilityClassObject;


public class ListnerImpClass implements ITestListener,ISuiteListener {
	ExtentReports report;
	
	public void onStart(ISuite suite) {
		
		// TODO Auto-generated method stub
		//configure report parameter
		System.out.println("Report Configuration...");
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvannceReport/report"+time+".html");
		spark.config().setDocumentTitle("CRM Test suite results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//add env info and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS","Windows-10");
		
				
		
		
	}

	
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backup");
		report.flush();
		
		
	}

	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("===========>"+result.getMethod().getMethodName()+"======START======");
		UtilityClassObject.setTest(report.createTest(result.getMethod().getMethodName()));
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("===========>"+result.getMethod().getMethodName()+"======END======");
	}

	
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot) BaseClass.sdriver;
		String filePath= eDriver.getScreenshotAs(OutputType.BASE64);
		
		String time= new Date().toString().replace(" ", "_").replace(":", "_");
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filePath,testName+"_"+time);
		
		
	}


}
