package tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import factories.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.GooglePage;

public class GoogleTest {

	String URL = "https://www.google.com/";
	@BeforeClass
	public void setupMethod() {
		WebDriverManager.chromedriver().setup();
	}
	
	@BeforeMethod
	public void initializeDriver() {
		
	}
	
	@Test(testName="Google Test", description = "This is a simple google test")
	public void googleTest() {
		DriverManager.get().get(URL);

		GooglePage gp = new GooglePage();
		gp.getGoogleInput().sendKeys("test");
		
	
		
		DriverManager.pauseThreadInSeconds(3);
	}

	@AfterMethod
	public void quitDriver() {
		DriverManager.get().close();
		DriverManager.get().quit();
	}
	
	
}
