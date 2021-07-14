package EtoE;



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

public class ValidateTitle extends base {
	public WebDriver driver;
	Logger log=LogManager.getLogger(ValidateTitle.class.getName());
	@BeforeTest
	public void initilize() throws IOException
	{
		driver = initialiseDriver();
		log.info("chrome is opened sucessfully");
		driver.get(prop.getProperty("url"));
        log.info("landed on homepage");
	}

	@Test()
	public void basePageNavigation() throws IOException
	{
		
		//call methods of other class 
		//1. inheritence.
		//2. Create object to that class & invoke the methods of it 
		LandingPage l= new LandingPage(driver);
		Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
		   log.info("Successfully validated the title");
	     
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
