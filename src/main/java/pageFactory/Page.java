package pageFactory;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

import factories.DriverManager;


public abstract class Page {
	
	public Page() {
		PageFactory.initElements(new DefaultElementLocatorFactory(DriverManager.get()), this);
	}
}
