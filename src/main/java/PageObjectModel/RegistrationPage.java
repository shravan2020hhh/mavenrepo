package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import maven.lockownmavenproject22.BaseTest;

public class RegistrationPage extends BaseTest //locmavpro22
{
	//Registration Page Properties
	@FindBy(xpath="//a[contains(text(),'Sign in')]") public WebElement singIn;
	@FindBy(id="email_create") public WebElement custEmail;
	@FindBy(id="SubmitCreate") public WebElement submit;
	@FindBy(xpath=".//*[@id='create_account_error']/ol/li") public WebElement error;
	@FindBy(id="id_gender1") public WebElement title_gen1;
	@FindBy(id="id_gender2") public WebElement title_gen2;
	@FindBy(id="customer_firstname") public WebElement firstName;
	@FindBy(id="customer_lastname") public WebElement lastName;
	@FindBy(id="passwd")public WebElement customerPassword;
	@FindBy(id="days") public WebElement dOB_day;
	@FindBy(id="months") public WebElement dOB_month;
	@FindBy(id="years") public WebElement dOB_year;
	@FindBy(id="firstname") public WebElement firtName_address;
	@FindBy(id="lastname") public WebElement lastName_address;
	@FindBy(id="company") public WebElement company;
	@FindBy(id="address1") public WebElement address_1;
	@FindBy(id="address2") public WebElement address_2;
	@FindBy(id="city") public WebElement city;
	@FindBy(id="id_state") public WebElement state;
	@FindBy(id="postcode") public WebElement postcode;
	@FindBy(id="id_country") public WebElement country;
	@FindBy(id="other") public WebElement textArea;
	@FindBy(id="phone") public WebElement phone;
	@FindBy(id="phone_mobile") public WebElement mobile_Phone;
	@FindBy(id="alias") public WebElement alias_address;
	@FindBy(id="submitAccount") WebElement submitAccount;
	 
	
	public RegistrationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void customerRegistration() throws InterruptedException
	{
		singIn.click();
		//custEmail.sendKeys(p.getProperty("fname")+p.getProperty("lname")+randomNumber()+p.getProperty("domain"));
		//System.out.println(custEmail.getAttribute("value"));
		custEmail.sendKeys("yash@gmail.com");
		submit.click();
		//Thread.sleep(3000);   //this or in basetest url(implicitwait)
		waitForElement(title_gen1, 60);//(not run)
		title_gen1.click();
		
		firstName.sendKeys("yash");
		lastName.sendKeys("test");
		customerPassword.sendKeys("12345");
		//dOB_day.sendKeys("25");
		//dOB_month.sendKeys("05");
		//dOB_year.sendKeys("2012");
	
		selectItem(dOB_day, 1);
		selectItem(dOB_month, 2);
		selectItem(dOB_year, 3);
		
		address_1.sendKeys("hyderabad");
		city.sendKeys("Hyderabad");
		state.sendKeys("california");
		postcode.sendKeys("1234");
		country.sendKeys("japan");
		mobile_Phone.sendKeys("1234567890");
	}




	
}
