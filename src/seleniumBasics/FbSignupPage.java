package seleniumBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbSignupPage {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.chrome.driver", ".//ChromeExe//chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("firstname")).sendKeys("Deepali");
		
		driver.findElement(By.name("lastname")).sendKeys("Sane");
		
		driver.findElement(By.name("reg_email__")).sendKeys("8149142352");
		
		driver.findElement(By.name("reg_passwd__")).sendKeys("Deepali@1");
		
		WebElement Day_dropdown = driver.findElement(By.id("day"));
		
		WebElement Month_dropdown = driver.findElement(By.id("month"));
		
		WebElement Year_dropdown = driver.findElement(By.id("year"));
		
		new Select(Day_dropdown).selectByVisibleText("1");

		new Select(Month_dropdown).selectByIndex(1);

		new Select(Year_dropdown).selectByValue("1992");
		
		driver.findElement(By.id("u_0_9")).click();

		Boolean MaleBtn = driver.findElement(By.id("u_0_a")).isEnabled();

		System.out.println("The Male button is enabled:" + MaleBtn);

		Boolean FemaleBtn = driver.findElement(By.id("u_0_9")).isDisplayed();

		System.out.println("The Female button is displayed:" + FemaleBtn);

		Boolean MaleBtn1 = driver.findElement(By.id("u_0_a")).isSelected();

		System.out.println("The Male button is checked:" + MaleBtn1);

		// driver.quit();

	}

}
