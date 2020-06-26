package seleniumBasics;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelReader {
	
	static Properties p ;

	public static void main(String[] args) {
		
		File fs = new File("C:\\Users\\Admin\\Desktop\\datafile.properties") ;
		
		try {
			
			FileInputStream fins = new FileInputStream(fs) ;
			
			Properties p = new Properties () ;
			
			p.load(fins);
			
			System.setProperty("webdriver.chrome.driver", ".//ChromeExe//chromedriver.exe") ;
			
			WebDriver driver = new ChromeDriver ();
			
			driver.manage().window().maximize();
			
			driver.get(p.getProperty("URL"));
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			String U = p.getProperty("userName") ;
			
			String P = p.getProperty("password") ;
			
			driver.findElement(By.id("txtUsername")).sendKeys(U);
			
			driver.findElement(By.id("txtPassword")).sendKeys(P);
			
			driver.findElement(By.id("btnLogin")).click();
		
			
		}
		
		catch(Exception e)
		
		{
			e.printStackTrace();
		}

	}

}
