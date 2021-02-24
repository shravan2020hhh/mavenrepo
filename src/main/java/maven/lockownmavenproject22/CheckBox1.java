package maven.lockownmavenproject22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class CheckBox1 extends BaseTest
{
  
	@BeforeMethod(groups = {"regression","smoke"})
	@Parameters("browser")//for selected browser and give string btype also at lounch
	  public void beforeMethod(String btype) throws Exception 
	  {
		init();
		LounchBrowser(btype);
		LounchUrl("checkboxurl");
		
	  }
	@Test(groups = {"regression","smoke"})
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
		}
	}
  @AfterMethod(groups = {"regression","smoke"})
  public void afterMethod() 
  {
	  driver.quit();
	 
  }

}
