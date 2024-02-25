package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {

	public WebDriver driver;
	//constructor name should be the same as a class name
	public OffersPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");//search -- variable, where we save the x-path
	By productName = By.cssSelector("tr td:nth-child(1)");//search and productName variables are global variables
	
	
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
}
