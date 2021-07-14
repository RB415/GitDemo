package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
	
	public WebDriver driver;
	By username=By.id("user_email");
	By password=By.id("user_password");
	By LogIn=By.name("commit");
	By forgotPass=By.xpath("//a[contains(text(),'Forgot Password?')]");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;

	}
	public  ForgotPassWord forgotPAssword()
	{
		driver.findElement(forgotPass).click();;
		ForgotPassWord fp=new ForgotPassWord(driver);
		return fp;
	}

	public WebElement getEmail()
	{
		return driver.findElement(username);
		
	}
	public WebElement getPass()
	{
		return driver.findElement(password);
		
	}
	public WebElement getLogIn()
	{
		return driver.findElement(LogIn);
		
	}

}
