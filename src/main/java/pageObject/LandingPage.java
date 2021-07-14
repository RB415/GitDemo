package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LandingPage {
	
	public WebDriver driver;
	By signin= By.cssSelector("a[href*='sign_in']");
	By title= By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigationaBar=By.xpath("//header/div[2]");
	public LandingPage(WebDriver driver) {
		this.driver=driver;

	}

	public LoginPage getLogin()
	{
		 driver.findElement(signin).click();
		 LoginPage lp= new LoginPage(driver);
		 return lp;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigationaBar()
	{
		return driver.findElement(navigationaBar);
	}

}
