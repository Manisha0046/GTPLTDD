package SeleniumPractice.GTPLTDD.Test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SeleniumPractice.GTPLTDD.Pages.LoginPage;
import SeleniumPractice.GTPLTDD.TestBase.Base;

public class LoginPageTest extends Base {
	
	public LoginPage loginpage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPositiveTestScneario()
	{
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		loginpage.Login_positive(username, password);

	}
	@Test(priority=0)
	public void LoginNegativeTestScneario()
	{
		String username=prop.getProperty("username");
		String password=prop.getProperty("wrongpassword");
		loginpage.Login_negative(username, password);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
