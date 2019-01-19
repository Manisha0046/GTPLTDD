package SeleniumPractice.GTPLTDD.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public Base()
	{
		prop=new Properties();
		FileInputStream fn;
		try 
		{
			fn = new FileInputStream("I:\\OrangeHRM\\GTPLTDD\\src\\main\\java\\SeleniumPractice\\GTPLTDD\\config\\Config.properties");
			prop.load(fn);
		} catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} catch (IOException e) 
		{
			e.printStackTrace();
		}		
	}
	
	public void initialization()
	{
		if(prop.getProperty("browser").contentEquals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		String URL=prop.getProperty("url");
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
}
