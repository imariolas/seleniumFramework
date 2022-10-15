package factories;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public class DriverManager {
	
	private static WebDriver driver;
	
	public static DriverFactory driverFactory;
	private static ConcurrentHashMap<Thread, WebDriver> webDrivers = new ConcurrentHashMap<Thread, WebDriver>();
	private static ThreadLocal<ITestContext> contexts = new ThreadLocal<ITestContext>();
	private static ConcurrentHashMap<ITestContext, List<Thread>> contextThreadMap = new ConcurrentHashMap<ITestContext, List<Thread>>();
	
	private static WebDriver initDriver() {
		System.out.println("[!] initialize driver");
		
		driver = driverFactory.getDriver(contexts.get());
		webDrivers.put(Thread.currentThread(), driver);

		return driver;
	}
	
	public static void register(ITestContext context) {
		if(context.getAttributeNames().size() > 0) {
			contexts.set(context);
			
		}
	}
	
	public static WebDriver get() {

		if(driver == null) {
			return initDriver();
		}else {
			return driver;
		}
		
	}
	
	public static void setDriverFactory(DriverFactory factory) {
		driverFactory = factory;
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
