package test.browseraction;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowManagement {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		/* ---------------------- Dimensions -------------------------- */
		// Get browser window size 
		int width = driver.manage().window().getSize().getWidth();
		int height = driver.manage().window().getSize().getHeight();
		
		System.out.println("Width:" + width);
		System.out.println("Height: " + height);
		
		// To set new dimensions / size to browser window
		driver.manage().window().setSize(new Dimension(800, 600));
		
		Thread.sleep(2000);
		
		/* ------------------- Position ------------------------------------*/
		int posX = driver.manage().window().getPosition().getX();
		int posY = driver.manage().window().getPosition().getY();
		
		System.out.println("Position x = " + posX + ", y = "+ posY);
		Thread.sleep(2000);
		
		// To set new position
		driver.manage().window().setPosition(new Point(0,0));
		Thread.sleep(2000);
		
		/* ---------------- Maximize/Minimize/FullScreen ----------------------- */
		// Maximize browser window
		driver.manage().window().maximize(); 
		Thread.sleep(2000);
		
		// Minimize browser window
		driver.manage().window().minimize();
		Thread.sleep(2000);
		
		// Full screen
		driver.manage().window().fullscreen();
		Thread.sleep(2000);
		driver.manage().window().maximize(); 
		
		/* ------------------- Take Screenshots -------------------------------- */
		driver.get("https://www.google.com");
		Thread.sleep(4000);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./image.png"));
		Thread.sleep(4000);
		
		WebElement elem = driver.findElement(By.cssSelector(".lnXdpd"));
		File srcFile2 = ((TakesScreenshot)elem).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile2, new File("./image2.png"));
		
		driver.close();
		driver.quit();		
	}

}
