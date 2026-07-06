package stepdefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utils.TextContextSetUp;

/**
 * Hooks for setUp and tearDown of each scenario
 */
public class Hooks {
	TextContextSetUp textContextSetUp;

	public Hooks(TextContextSetUp textContextSetUp) {
		this.textContextSetUp = textContextSetUp;
	}

	@Before
	public void setUp() {
		System.out.println("========================================");
		System.out.println("🚀 Starting Test Scenario");
		System.out.println("========================================");
	}

	@After
	public void tearDown() throws IOException {
		System.out.println("========================================");
		System.out.println("✅ Test Scenario Completed");
		System.out.println("========================================");
		textContextSetUp.testBase.quitDriver();
	}

	@AfterStep
	public void addScreenShot(Scenario scenario) throws WebDriverException, IOException {
		WebDriver driver = textContextSetUp.testBase.WebDriverManager();
		if (scenario.isFailed()) {
			//screenshot code if failed 
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			
			// Attach to Cucumber scenario
			scenario.attach(fileContent, "image/png", scenario.getName() + " - Failed Screenshot");
			
			// Also attach to Allure for better visualization
			Allure.addAttachment(
				scenario.getName() + " - Failed Screenshot",
				"image/png",
				new java.io.ByteArrayInputStream(fileContent),
				".png"
			);
		}
	}

}
