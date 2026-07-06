package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.linkText("Top Deals");
	private By increment = By.cssSelector("a.increment");
	private By addToCart = By.cssSelector(".product-action button");

	public void searchItems(String vegShortName) {
		driver.findElement(search).sendKeys(vegShortName);

	}

	public void getSearchText() {
		driver.findElement(search).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}

	public String getTitleLandingPage() {
		return driver.getTitle();
	}

	public void incrementQuantity(int quantity) {
		for (int i = 1; i < quantity; i++) {
			driver.findElement(increment).click();
		}
	}

	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}
