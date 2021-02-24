package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	@FindBy(xpath="//a[contains(text(),'Sign in')]") public WebElement singIn;
	@FindBy(id="email") public WebElement customerEmail;
	@FindBy(id="passwd") public WebElement customerPassword;
	@FindBy(xpath="//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")public WebElement submitLogin;
	@FindBy(xpath="//li[contains(text(),'Authentication failed.')]")public WebElement getLoginErrorMessege;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}


	public void login()
	{
		singIn.click();
		customerEmail.sendKeys("yash@gmail.com");
		customerPassword.sendKeys("12345");
		submitLogin.click();
	}
	
	public String getLoginError()
	{
		return getLoginErrorMessege.getText();
	}
	
//		WebDriver driver;
//		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//drivers//chromedriver.exe" );
//		driver=new ChromeDriver();
//		driver.get("http://automationpractice.com/index.php");
//		driver.manage().window().maximize();
//		
//		driver.findElement(By.cssSelector("body.index.hide-left-column.hide-right-column.lang_en:nth-child(2) div.header-container div.nav:nth-child(2) div.container div.row nav:nth-child(1) div.header_user_info:nth-child(1) > a.login")).click();
//	    driver.findElement(By.id("email")).sendKeys("yash@gmail.com");
//	    driver.findElement(By.id("passwd")).sendKeys("12345");
//	    driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/p[2]/button[1]/span[1]")).click();
//	    String actualError = driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]")).getText();
//	    String expectedError = "Authentication failed.";
//	    Assert.assertEquals(actualError, expectedError);
//	
	
}
