package maven.lockownmavenproject22;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest 
{
	public static WebDriver driver;
	public static String projectpath=System.getProperty("user.dir");
	public static Properties p;
	
	public static FileInputStream fis;
	public static Properties envprop;
	public static Properties prop;
	public static Properties or;
	
	public static ExtentReports report;
	public static ExtentTest test;
	public static String screenshotFileName=null;
	
	public static void init() throws Exception 
	{
		fis=new FileInputStream(projectpath+"//data.properties");
		p=new Properties();
		p.load(fis);
		
		fis=new FileInputStream(projectpath+"//or.properties");
		or=new Properties();
		or.load(fis);
		
		fis=new FileInputStream(projectpath+"//enviroment.properties");
		prop=new Properties();
		prop.load(fis);
		String e = prop.getProperty("env");//get env prop and storing it
		System.out.println(e);
		
		fis=new FileInputStream(projectpath+"//"+e+".properties");
		envprop=new Properties();
		envprop.load(fis);
		String val = envprop.getProperty("automationurl");//storing
		System.out.println(val);
		
		//any conf files loading like this bcoz config is the static method
		fis=new FileInputStream(projectpath+"//logconfig.properties");
		PropertyConfigurator.configure(fis);
		
		report = ExtentManager.getInstance();
	}
	
	public static void LounchBrowser(String browser) 
	{
		if(p.getProperty(browser).equals("chrome"))//no need p.getprop give direct browser
		{
		System.setProperty("webdriver.chrome.driver", projectpath+"//drivers//chromedriver.exe" );
		ChromeOptions option=new ChromeOptions();
		option.addArguments("user-data-dir=C:\\Users\\HP\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
		
		option.addArguments("--disable=notifications");//block notification
		
		driver=new ChromeDriver(option);
		}
		else if(p.getProperty(browser).equals("firefox"))//no need p.getprop give direct browser
		{
		System.setProperty("webdriver.gecko.driver", projectpath+"//drivers//geckodriver.exe");
		
		//sholud create profileini object & get firefox name which was creaed 
		//then create option object and set profile
		ProfilesIni p=new ProfilesIni();
		FirefoxProfile profile = p.getProfile("prasanna");//storing
		System.out.println(profile);
		profile.setPreference("dom.webnotifications.enabled", false);//block notification
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		
		driver=new FirefoxDriver(option);
		}
	}
	
	public static void LounchUrl(String url) 
	{	
		//driver.get(url);
		//driver.get(p.getProperty(url));
		driver.navigate().to(p.getProperty(url));
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	

	public static void selectDropItem(String locatorkey, String item) {
		//getElement(locatorkey).sendKeys(or.getProperty(item));
		driver.findElement(By.id("searchDropdownBox")).sendKeys("Books");
	}

	
	public static void clickElement(String locatorkey) {
		//getElement(locatorkey).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/header[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[3]/div[1]/span[1]/input[1]")).click();
		
	}

	public static void typeValue(String locatorkey, String value) {
		//getElement(locatorkey).sendKeys(or.getProperty(value));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("bhagvatgeetha");
		
	}

	public static WebElement getElement(String locatorkey)
	{
		WebElement element=null;
		if(locatorkey.endsWith("_id")) {
			driver.findElement(By.id(or.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_name")) {
			driver.findElement(By.name(or.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_classname")) {
			driver.findElement(By.className(or.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_xpath")) {
			driver.findElement(By.xpath(or.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_css")) {
			driver.findElement(By.cssSelector(or.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_linktext")) {
			driver.findElement(By.linkText(or.getProperty(locatorkey)));
		}else if(locatorkey.endsWith("_partiallinktext")) {
			driver.findElement(By.partialLinkText(or.getProperty(locatorkey)));
		}
			
		return null;
	}
	
	public void waitForElement(WebElement locator,int seconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	public int randomNumber() 
	{
		Random r=new Random();
		return r.nextInt(55555);
	}
	
	public void selectItem(WebElement element,int itemIndex) 
	{
		Select s=new Select(element);
		s.selectByIndex(itemIndex);
	}

	
	//******************varification******************
	
	public static boolean varifyElement(String expectedLink) 
	{
		String actualLink =driver.findElement(By.xpath("//a[contains(text(),'Customer Service')]")).getAttribute("innerHTML");
		
		System.out.println("Actual Link :"+actualLink);
		System.out.println("Expected Link :"+expectedLink);
		 
		if(actualLink.contains(actualLink))
			return true;
		else
			return false;
	}
	
	//******************reporting******************

	public static void reportSuccess(String successMsg)
	{
		 test.log(LogStatus.PASS, successMsg);
	}

	public static void reportFailure(String failureMsg) 
	{
		test.log(LogStatus.FAIL, failureMsg);
		takescreenshot();
	}
	public static void takescreenshot()
	{
		Date dt=new Date();
		screenshotFileName = dt.toString().replace("'", "_").replace(":", "_")+".png";
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try 
		{
			FileHandler.copy(srcfile, new File(projectpath+"//failure//"+screenshotFileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//put screenshot file in extentreport
		test.log(LogStatus.INFO, "screenshot--->"+test.addScreenCapture(projectpath+"//failure//"+screenshotFileName));
	}
}
