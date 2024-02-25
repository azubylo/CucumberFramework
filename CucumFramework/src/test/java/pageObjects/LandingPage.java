package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	//constructor name should be the same as a class name
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");//search -- variable, where we save the x-path
	By productName = By.cssSelector("h4.product-name");//search and productName variables are global variables
	By topDeals = By.linkText("Top Deals");
	
	
	public void searchItem(String name)//here we create action matters
	{
		driver.findElement(search).sendKeys(name);

	}
	
	public void getSearchText()//here we create action matters
	{
		driver.findElement(search).getText();

	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
}
