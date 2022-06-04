package test;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserAction {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		String originalWindow = driver.getWindowHandle();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));  
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		
		driver.get("https://www.google.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.navigate().to("https://www.selenium.dev/");
		
		// Get current URL
		System.out.println("Current URL: " + driver.getCurrentUrl());
		
		// Get Title
		System.out.println("Title: " + driver.getTitle());
		
		driver.navigate().back();
		Thread.sleep(2);
		driver.navigate().forward();
		Thread.sleep(2);
		driver.navigate().refresh();
		
		
		
		driver.switchTo().newWindow(WindowType.WINDOW); // creating new window 
		driver.switchTo().newWindow(WindowType.TAB);	// creating new tab.
		
		driver.switchTo().window(originalWindow); // Swtching to original window
		
		driver.close();// closes current session/tab
		//driver.quit(); // Closes current all windows/all sessions
	}
}
