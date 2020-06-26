package seleniumBasics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.io.FileHandler;

public class CaptureScreenshot {

public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", ".//ChromeExe//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");

		Boolean LoginBtn = driver.findElement(By.id("btnLogin")).isDisplayed();
		
		System.out.println("The Login button is displayed:" +LoginBtn);
		
		driver.findElement(By.id("btnLogin")).click();
		
		TakesScreenshot Ts = (TakesScreenshot)driver;

		File Srcfile = Ts.getScreenshotAs(OutputType.FILE);
		
		File Destfile = new File(".//Screenshot//openhrm.login.png");
		
		FileHandler.copy(Srcfile, Destfile);
		
		driver.quit();
	
	}

}
