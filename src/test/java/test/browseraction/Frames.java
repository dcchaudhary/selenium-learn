package test.browseraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		/* ----------- Switching to the frame ---------------- */
		driver.switchTo().frame("packageFrame"); // <iframe src="allclasses-frame.html" name="packageFrame" ...>
		
		// ------ Alternate way to switch to frame -------------
		//WebElement frame = driver.findElement(By.cssSelector(".leftBottom>iframe"));
		//driver.switchTo().frame(frame);
		
		//driver.switchTo().frame(0); // index can also be used instead of name or element of frame
		/* --------------------------------------------------- */
		driver.findElement(By.linkText("Alert")).click(); // Unfortunately this did not work even though element is present
		
		driver.switchTo().defaultContent(); // to switch back to top level window
		
		Thread.sleep(4000);
		driver.close();
		driver.quit();
		
	}

}
