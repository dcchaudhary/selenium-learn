package test.browseraction;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		Thread.sleep(4000);
		//WebElement popup = driver.findElement(By.cssSelector("button[aria-label='No thanks']"));
		//popup.click();
		Thread.sleep(1000);
		/*---------------- JavaScript Executor ----------------- */
		// Getting 'Alt' attribute of web element
		WebElement elem = driver.findElement(By.cssSelector(".lnXdpd")); // get element
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String altText = (String)js.executeScript("return arguments[0].getAttribute('Alt')", elem);
		System.out.println(altText);
		/* --------------------------------------------------  */
		//  Clicking a button
		WebElement elem2 = driver.findElement(By.name("btnI")); // get button
		js.executeScript("return arguments[0].click();", elem2); // click on button
		/* --------------------------------------------------  */
		Thread.sleep(4000);	
		js.executeScript("console.log('Hello World')");	// executing script in console
		Thread.sleep(4000);
		
		//driver.close();
		//driver.quit();			
	}

}
