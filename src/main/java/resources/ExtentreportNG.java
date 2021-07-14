package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportNG {
	static ExtentReports extent ;
	public static ExtentReports getExtentReport()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html"; // creating folder to strore reports
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		 extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Rushikesh");
		return extent;
	}

}
