package EtoE;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.base;

public class ValidateNavigationBar extends base {
	public WebDriver driver;
	Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initilize() throws IOException
	{
		driver = initialiseDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test()
	public void basePageNavigation() throws IOException
	{
		//call methods of other class 
		//1. inheritence.
		//2. Create object to that class & invoke the methods of it 
		LandingPage l= new LandingPage(driver);
		
	    Assert.assertTrue(l.getNavigationaBar().isDisplayed());
	    log.info("Navigation Bar is displayed");
	
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
