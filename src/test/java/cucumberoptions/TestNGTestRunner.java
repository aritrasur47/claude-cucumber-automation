package cucumberoptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features",
				 glue = "stepdefinitions",
				 tags = "@PlaceOrder or @SearchProduct",
					monochrome = true,
					plugin = {"pretty", 
							"html:target/cucumber-reports.html",
							"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
							"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
							"rerun:target/failed_scenarios.txt"}
		
				)

public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	// Re-enabled parallel execution to reduce total runtime
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}

