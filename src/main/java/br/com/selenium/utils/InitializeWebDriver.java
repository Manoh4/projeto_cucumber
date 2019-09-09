package br.com.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitializeWebDriver {
	
	private static WebDriver driver;
	
	public static WebDriver getWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("http://srbarriga.herokuapp.com/login");
		return driver;
	}

}
