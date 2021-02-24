package PageObjectModel;

import org.testng.annotations.Test;

import maven.lockownmavenproject22.BaseTest;

import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class POM_001 extends BaseTest //locmavpro22
{
  @BeforeTest
  public void startTest() throws Exception
 {
		init();
		LounchBrowser("chromebrowser");
		LounchUrl("automationurl");
 }

  @Test(priority = 1)
  public void loginTest() 
  {
	  LoginPage page=new LoginPage(driver);
	  page.login();
	  Assert.assertEquals(page.getLoginError(), "Authentication failed.");
  }
  @Test(priority = 2)
  public void registration() throws InterruptedException
  {
	  RegistrationPage reg=new RegistrationPage(driver);
	  reg.customerRegistration();
  }
  
  @AfterTest
  public void endTest() 
  {
	  driver.quit();
  }

}
