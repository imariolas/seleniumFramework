package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	WebDriver driver;
	String URL = "https://www.google.com/";
	@BeforeClass
	public void setupMethod() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	public void initializeDriver() {
		driver = new ChromeDriver();
	}
	
	@Test(testName="Google Test", description = "This is a simple google test")
	public void googleTest() {
		driver.get(URL);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void quitDriver() {
		driver.close();
		driver.quit();
	}
	
	
}
