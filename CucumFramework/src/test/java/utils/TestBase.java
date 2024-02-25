package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LandingPage;

public class TestBase {

	public WebDriver driver;
	
	public WebDriver WebdriverMananager()
	{
		if(driver == null)
		{
		driver = new ChromeDriver();//driver gets the life
		driver.get("https://google.com");
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		}
		return driver;
	}
}
