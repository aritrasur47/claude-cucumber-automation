package utils;

/**
 * Central location for all test constants including delays and timeouts
 * Easily configurable for different environments
 */
public class TestConstants {
	
	// ===================== Wait/Delay Constants (in milliseconds) =====================
	// Reduced delays for faster execution while keeping some visibility
	public static final long PAGE_LOAD_DELAY = 800;
	public static final long SEARCH_DELAY = 400;
	public static final long ELEMENT_VISIBILITY_DELAY = 300;
	public static final long CART_ACTION_DELAY = 300;
	public static final long CHECKOUT_DELAY = 500;
	public static final long VALIDATION_DELAY = 300;
	public static final long PROMO_VERIFICATION_DELAY = 300;
	
	// ===================== WebDriverWait Timeout (in seconds) =====================
	// Shorter explicit/implicit waits to reduce runtime; adjust if flakiness occurs
	public static final int EXPLICIT_WAIT_TIMEOUT = 5;
	public static final int IMPLICIT_WAIT_TIMEOUT = 2;
	
	// ===================== Test URLs =====================
	public static final String GREENKART_URL = "https://rahulshettyacademy.com/seleniumPractise/#/";
	public static final String GREENKART_TITLE = "GreenKart";
	
	// ===================== Browser Options =====================
	public static final String DEFAULT_BROWSER = "chrome";
	
	// ===================== Test Data =====================
	public static final String TOMATO_SHORTNAME = "Tom";
	public static final String CARROT_SHORTNAME = "Car";
	public static final String DEFAULT_QUANTITY = "3";
}
