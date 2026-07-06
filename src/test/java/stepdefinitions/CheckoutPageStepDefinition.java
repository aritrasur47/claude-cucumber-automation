package stepdefinitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import utils.TestConstants;
import utils.TextContextSetUp;
import utils.WaitUtils;

public class CheckoutPageStepDefinition {

	CheckOutPage checkOutPage;
	TextContextSetUp textContextSetUp;
	WaitUtils waitUtils;

	public CheckoutPageStepDefinition(TextContextSetUp textContextSetUp) {
		this.textContextSetUp = textContextSetUp;
		this.checkOutPage = textContextSetUp.pageObjectManager.getCheckoutPage();
		this.waitUtils = new WaitUtils(textContextSetUp.driver);
	}

	@Then("^User proceeds to checkout page and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_page_and_validate_the_items_in_checkout_page(String productName) throws InterruptedException {
		waitUtils.delay(TestConstants.CHECKOUT_DELAY);
		checkOutPage.checkoutItems();
		waitUtils.delay(TestConstants.CHECKOUT_DELAY);
	}

	@And("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws InterruptedException {
		waitUtils.delay(TestConstants.PROMO_VERIFICATION_DELAY);
		Assert.assertTrue(checkOutPage.verifyPromoBtn());
		waitUtils.delay(TestConstants.PROMO_VERIFICATION_DELAY);
		Assert.assertTrue(checkOutPage.verifyPlaceOrder());
		waitUtils.delay(TestConstants.CHECKOUT_DELAY);
	}

}
