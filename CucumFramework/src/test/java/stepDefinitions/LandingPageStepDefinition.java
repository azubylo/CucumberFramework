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
import utils.TestContextSetup;

public class LandingPageStepDefinition {
public WebDriver driver;
public String landingPageProductName;
public String offerPageProductName;
TestContextSetup testContextSetup;
	//Spring framework, EJB, 

public LandingPageStepDefinition(TestContextSetup testContextSetup)//testContextSetup is a default matter
{
	this.testContextSetup=testContextSetup;
}  //this is a constructor
//Pico-container allows us to jump from one window to another with two step definitions,
//one foe each window

	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
	    
		testContextSetup.driver = new ChromeDriver();//driver gets the life
		testContextSetup.driver.get("https://google.com");
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
				
	}
	@When("User searches with Shortname {string} and extracts actual name of product")
	public void user_searches_with_shortname_and_extracts_actual_name_of_product(String shortName) throws InterruptedException {
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
	    landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(landingPageProductName +" is extracted from Home page");
	}

	
}
