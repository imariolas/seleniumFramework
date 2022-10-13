package factories;

import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
	
	private static WebDriver driver;
	private static ConcurrentHashMap<WebDriver, Thread> threading = new ConcurrentHashMap<WebDriver, Thread>();
	
	
	private static WebDriver initializeDriver() {
		System.out.println("[!] initialize driver");
		driver = null;
		driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver get() {
		System.out.println(Thread.currentThread());
		if(driver == null) {
			return initializeDriver();
		}else {
			System.out.println("[!] return the driver");
			return driver;
		}
		
		
	}

	public static void pauseThreadInSeconds(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
