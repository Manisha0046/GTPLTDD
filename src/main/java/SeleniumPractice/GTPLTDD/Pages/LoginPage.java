package SeleniumPractice.GTPLTDD.Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import SeleniumPractice.GTPLTDD.TestBase.Base;

public class LoginPage extends Base {

	@FindBy(name="uid")
	WebElement userID_txt;
	
	@FindBy(name="password")
	WebElement password_txt;
	
	@FindBy(name="btnLogin")
	WebElement btn_login;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Login_positive(String username,String password)
	{
		userID_txt.sendKeys(username);
		password_txt.sendKeys(password);
		btn_login.click();
	}
	
	public void Login_negative(String username,String password)
	{
		userID_txt.sendKeys(username);
		password_txt.sendKeys(password);
		btn_login.click();
		Alert alert=driver.switchTo().alert();
		String actual=alert.getText();
		String expected=actual;
		Assert.assertEquals(actual, expected);
		alert.accept();
		
	}
	
}
