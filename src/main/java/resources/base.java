package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initialiseDriver() throws IOException
	{
		 prop= new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\PRIYA\\eclipse-workspaceNew\\EtoE\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String broweserName=prop.getProperty("browser");
		if(broweserName.equals("chrome"))
		{
			//execute in chrome;
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (broweserName.equals("firefox"))
		{
			
			// execute in firefox
		
		}
		else if (broweserName.equals("ie"))
		{
			//execute in IE
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
		
	}
	public String getScreenshot(String TestcaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"//reports//"+TestcaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
	}
}
