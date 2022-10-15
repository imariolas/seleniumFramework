package factories;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;

public interface DriverFactory {
	public WebDriver getDriver(ITestContext context);
}
