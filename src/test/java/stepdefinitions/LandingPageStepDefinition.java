package stepdefinitions;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestConstants;
import utils.TextContextSetUp;
import utils.WaitUtils;

public class LandingPageStepDefinition {

	TextContextSetUp textContextSetUp;
	LandingPage landingPage;
	WaitUtils waitUtils;

	public LandingPageStepDefinition(TextContextSetUp textContextSetUp) {
		this.textContextSetUp = textContextSetUp;
		this.landingPage = textContextSetUp.pageObjectManager.getLandingPage();
		this.waitUtils = new WaitUtils(textContextSetUp.driver);
	}

	@Given("User is on Greenkart landing page")
	public void user_is_on_greenkart_landing_page() throws InterruptedException {
		waitUtils.delay(TestConstants.PAGE_LOAD_DELAY);
		Assert.assertTrue(landingPage.getTitleLandingPage().contains(TestConstants.GREENKART_TITLE));
		waitUtils.delay(TestConstants.ELEMENT_VISIBILITY_DELAY);
	}

	@When("^User searched with Shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String vegShortName) throws InterruptedException {
		
		landingPage.searchItems(vegShortName);
		waitUtils.delay(TestConstants.SEARCH_DELAY);
		
		// Wait for the product name to be visible
		waitUtils.waitForElementToBeVisible(By.cssSelector("h4.product-name"));
		
		waitUtils.delay(TestConstants.ELEMENT_VISIBILITY_DELAY);
		textContextSetUp.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(textContextSetUp.landingPageProductName + " is extracted from the HomePage");
	}
	
	@And("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity) throws InterruptedException {
		waitUtils.delay(TestConstants.CART_ACTION_DELAY);
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		waitUtils.delay(TestConstants.CART_ACTION_DELAY);
		landingPage.addToCart();
		waitUtils.delay(TestConstants.CHECKOUT_DELAY);
	}

}
