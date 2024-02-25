package stepDefinitions;

import java.util.Set;
import java.time.Duration;
import java.util.Iterator;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.http.ClientConfig;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
public WebDriver driver;
public String landingPageProductName;
public String offerPageProductName;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;
//Single responsibility principle
//loosely coupled -- dependency injection, so you can move matters anywhere in another class without any hustle
//tightly coupled
//Factory Design Pattern
public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
}

	@Then("User searches for {string} shortname in offers page")
	public void user_searches_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
	    // offer page>enter>grab text
		
		switchToOffersPage();
		
		OffersPage offersPage = new OffersPage(testContextSetup.driver);
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offersPage.getProductName();
	}

	
	public void switchToOffersPage()
	{
		//if you already switched to offer page -> skip below part
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
		//pageObjectManager = new PageObjectManager(testContextSetup.driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
		//explicit wait, parse string
	}
	
	
	@Then("Validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_Offers_page()
	{
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}

	
}
