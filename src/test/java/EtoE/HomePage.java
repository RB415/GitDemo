package EtoE;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.ForgotPassWord;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class HomePage extends base
{
	public WebDriver driver;
	Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initilize() throws IOException, InterruptedException
	{
		driver = initialiseDriver();
	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String username,String Password, String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		
		//call methods of other class 
		//1. inheritence.
		//2. Create object to that class & invoke the methods of it 
		LandingPage l= new LandingPage(driver);
		LoginPage lp= l.getLogin();
		
		lp.getEmail().sendKeys(username); 
		lp.getPass().sendKeys(Password);
		lp.getLogIn().click();
		//System.out.println(text);
		log.info(text);
		ForgotPassWord fp =lp.forgotPAssword();
		fp.getEmail().sendKeys("abc@gmail.com");
		fp.submit().click();
	
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		//coloumn stands for how many values per each test  
		Object[][] data=new Object[2][3];
		
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123698";
		data[0][2]="NonRestricted_USEr";
		
		data[1][0]="restricteduser@qw.com";
		data[1][1]="3693859";
		data[1][2]="Restricted_USEr";
		
		return data;
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit(); 
	}
}
