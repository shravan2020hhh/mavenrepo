package maven.lockownmavenproject22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class RadioButton1 extends BaseTest
{

	@BeforeMethod(groups = {"regression"})
	@Parameters("browser")//for selected browser and give string btype also at lounch
	  public void beforeMethod(String btype) throws Exception 
	  {
		init();
		LounchBrowser(btype);
		LounchUrl("radiourl");
	}
	@Test(groups = {"regression"})
	public void radioButton1()
	{
		WebElement radio=driver.findElement(By.xpath("(//td[@class='table5'])[2]"));
		List<WebElement> rbutton=radio.findElements(By.name("group1"));
		for(int i=0;i<rbutton.size();i++)
		{
			System.out.println(rbutton.get(i).getAttribute("value")+ "----" + rbutton.get(i).getAttribute("checked"));
		}
	}
 

  @AfterMethod(groups = {"regression"})
  public void afterMethod() 
  {
	 driver.quit();
	  
  }
	
}
