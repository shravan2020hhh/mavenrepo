package maven.lockownmavenproject;

import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager extends BaseTest
{

	public static ExtentReports extent;
	
	public static ExtentReports getInstance() 
	{
		if(extent==null);
		{
		Date dt=new Date();
		String FilePath = dt.toString().replace("'", "_").replace(":", "_")+".html";
		extent=new ExtentReports(projectpath+"//HTMLReports//"+FilePath);
		extent.loadConfig(new File(projectpath+"//extentconfigreport.xml"));
		extent.addSystemInfo("Selenium Language", "3.11.0").addSystemInfo("enviroment", prop.getProperty("env"));
		}return extent;
	}
	
}