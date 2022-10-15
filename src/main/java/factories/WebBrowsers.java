package factories;

public class WebBrowsers {
	
	private final static String[] browserNames = {
			"chrome",
			"firefox",
			"ie",
			"edge",
			"safari",
			"phantomjs"};
	
	public enum WebBrowser{
		CHROME("chrome"),
		FIREFOX("firefox"),
		INTERNET_EXPLORER("ie"),
		MICROSOFT_EDGE("edge"),
		SAFARI("safari"),
		PHANTOMJS("phantomjs"),
		NONE("none");
		
		String browser;
		
		WebBrowser(String browser){
			this.browser = browser;
		}
	}
	
	
	public static boolean isAccepted(String browser) {
		for(String browserName : browserNames) {
			if(browserName.equals(browser)) {
				System.out.println("Browser is Accepted!");
				return true;
			}
		}
		
		return false;
	}
	
	
	public static WebBrowser getWebBrowser(String browser) {
		if(isAccepted(browser)) {
			for(WebBrowser webBrowser : WebBrowser.values()) {
				if(webBrowser.browser.equals(browser))
					return webBrowser;
			}
		}
		return null;
	}
	
}
