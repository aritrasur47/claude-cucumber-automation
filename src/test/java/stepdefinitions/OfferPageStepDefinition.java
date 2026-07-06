package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestConstants;
import utils.TextContextSetUp;
import utils.WaitUtils;

public class OfferPageStepDefinition {

	String offersPageProductName;
	TextContextSetUp textContextSetUp;
	WaitUtils waitUtils;

	public OfferPageStepDefinition(TextContextSetUp textContextSetUp) {
		this.textContextSetUp = textContextSetUp;
		this.waitUtils = new WaitUtils(textContextSetUp.driver);
	}
	

	@Then("^User searched for (.+) Shortname in the offers page$")
	public void user_searched_for_shortname_in_the_offers_page(String vegShortName) throws InterruptedException {
		switchToOffersPage();
		OffersPage offersPage = new OffersPage(textContextSetUp.driver);
		offersPage.searchItems(vegShortName);
		waitUtils.delay(TestConstants.SEARCH_DELAY);
		
		// Wait for the product name to be visible
		waitUtils.waitForElementToBeVisible(By.cssSelector("tr td:nth-child(1)"));
		
		waitUtils.delay(TestConstants.ELEMENT_VISIBILITY_DELAY);
		offersPageProductName = offersPage.getProductName();
	} 
	
	
	public void switchToOffersPage() throws InterruptedException {
		LandingPage landingPage = textContextSetUp.pageObjectManager.getLandingPage();		
		landingPage.selectTopDealsPage();
		waitUtils.delay(TestConstants.PAGE_LOAD_DELAY);
		
		textContextSetUp.genericUtils.switchToChildWindow();
		waitUtils.delay(TestConstants.SEARCH_DELAY);
		
		// Wait for the search field to be present in the offers page
		waitUtils.waitForElementToBePresent(By.xpath("//input[@type='search']"));
	}


	@And("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() throws InterruptedException {
		waitUtils.delay(TestConstants.VALIDATION_DELAY);
		Assert.assertEquals(textContextSetUp.landingPageProductName, offersPageProductName, 
			"Product name mismatch: Landing page has '" + textContextSetUp.landingPageProductName + 
			"' but Offers page has '" + offersPageProductName + "'");
	}
}
