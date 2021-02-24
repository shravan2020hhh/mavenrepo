package maven.lockownmavenproject;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Tc__05 extends BaseTest
{
	private static final org.apache.log4j.Logger log=org.apache.log4j.Logger.getLogger(Tc__05.class);
	
	public static void main(String[] args) throws Exception 
	{
		 init();
		 ExtentTest test = report.startTest("Tc__05");
		test.log(LogStatus.INFO, "initializing the properties file..(data,log4jconfig,or,enviroment.....");
		
		LounchBrowser("chromebrowser");
		test.log(LogStatus.INFO, "opened the browser :-" +p.getProperty("chromebrowser"));
		
		LounchUrl("amazonurl");		
		test.log(LogStatus.INFO, "navigate to url :-" +p.getProperty("amazonurl"));
		
		selectDropItem("amazondropbox_id","amazondropvalue");	
		test.log(LogStatus.PASS, "selected the option :-" +or.getProperty("amazondropvalue")+ "by using the locator :-" +or.getProperty("amazondropbox_id"));
		
		typeValue("amazonsearchtext_id","amazonsearchtext");	
		test.log(LogStatus.FAIL, "entered the text :-" +or.getProperty("amazonsearchtext")+ "by using the locator :-" +or.getProperty("amazonsearchtext_id"));
		
		clickElement("amazonsearchbutton_xpath");	
		test.log(LogStatus.SKIP, "clicked on element by using the locator :-"+ or.getProperty("amazonsearchbutton_xpath"));
		
		report.endTest(test);
		report.flush();

	}

}
