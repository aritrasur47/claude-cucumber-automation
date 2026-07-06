package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitUtils {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public WaitUtils(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(TestConstants.EXPLICIT_WAIT_TIMEOUT));
	}
	
	/**
	 * Wait for an element to be visible on the page
	 */
	public void waitForElementToBeVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * Wait for an element to be visible on the page with custom timeout
	 */
	public void waitForElementToBeVisible(By locator, int timeoutInSeconds) {
		WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		customWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	/**
	 * Wait for an element to be present in the DOM
	 */
	public void waitForElementToBePresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * Wait for an element to be present in the DOM with custom timeout
	 */
	public void waitForElementToBePresent(By locator, int timeoutInSeconds) {
		WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		customWait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	/**
	 * Add a delay for visibility purposes (in milliseconds)
	 */
	public void delay(long millis) throws InterruptedException {
		Thread.sleep(millis);
	}
}
