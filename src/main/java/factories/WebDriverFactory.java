package factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.ITestContext;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory implements DriverFactory{

	
	public static String BROWSER_NAME = "browser";
	public static String PLATFORM = "platform";
	
	private static WebDriver driver;
	
	public WebDriver getDriver(ITestContext context) {
		String browser = (String) context.getAttribute(BROWSER_NAME);
		String platform = (String) context.getAttribute(PLATFORM);
		return getLocalDriver(browser, platform);
	
	}
	
	public static WebDriver getLocalDriver(String browser, String platform) {
		WebDriver driver = null;
		WebBrowsers.WebBrowser browserName = WebBrowsers.getWebBrowser(browser); ;
		
		switch(browserName) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			ChromeOptions chromeOptions = new ChromeOptions();
			//chromeOptions.addArguments("start-maximized");
			
			driver = new ChromeDriver(chromeOptions);
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.addArguments("start-maximized");
			driver = new FirefoxDriver();
			
			break;
		case MICROSOFT_EDGE:
			WebDriverManager.edgedriver().setup();
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.addArguments("start-maximized");
			
			driver = new EdgeDriver(edgeOptions);
			break;
		case SAFARI:
			
			WebDriverManager.safaridriver().setup();
			SafariOptions safariOptions = new SafariOptions();
			driver = new SafariDriver();
			break;
		case INTERNET_EXPLORER:
			break;
		case PHANTOMJS:
			
			break;
		default :
			System.out.println("[!] No browser found");
		}
		

		return driver;
	}
	
	
	public void getRemoteDriver() {
		
	}
	

}
