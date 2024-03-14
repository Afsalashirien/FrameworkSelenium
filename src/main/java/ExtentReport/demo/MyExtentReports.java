package ExtentReport.demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyExtentReports {

	
	
	public static ExtentReports getReportObject() {
		
		
String path = System.getProperty("user.dir") + "\\reports\\index.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("extentDemo");
		
		reporter.config().setDocumentTitle("demoresults");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(reporter);
		
		extent.setSystemInfo("Tester","Afsala");
		
		return extent;
	}
	
	
}
