package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import factories.DriverManager;
import pageFactory.Page;

public class GooglePage extends Page{

	@FindBy(name="q")
	protected WebElement googleInput;
	
	@FindBy(name="btnK")
	protected WebElement searchBtn;
	
	public WebElement getGoogleInput() {
		return googleInput;
	}
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
}
