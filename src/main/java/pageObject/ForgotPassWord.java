package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassWord {
	
	public WebDriver driver;
	By username=By.id("user_email");
	By submit=By.name("commit");
	
	
	public ForgotPassWord(WebDriver driver) {
		this.driver=driver;

	}
	
	

	public WebElement getEmail()
	{
		return driver.findElement(username);
		
	}
	public WebElement submit()
	{
		return driver.findElement(submit);
		
	}
	

	

}
