package seleniumBasics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindows {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".//ChromeExe//chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://www.naukri.com/");

		String ParentWindowId = driver.getWindowHandle();

		Set<String> set = driver.getWindowHandles();
		
		System.out.println(set);

		Iterator<String> itr = set.iterator();

		while (itr.hasNext()) 
		{
			String childWindow = itr.next();

			if (!ParentWindowId.equals(childWindow))
			{
				driver.switchTo().window(childWindow);
				System.out.println(driver.switchTo().window(childWindow).getTitle());
				driver.switchTo().window(ParentWindowId);
			}

		}
		
		driver.close();
	}

}