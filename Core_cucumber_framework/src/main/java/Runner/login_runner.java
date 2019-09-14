package Runner;

import org.junit.runner.RunWith;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "E:/Mobile_testing/Core_cucumber_framework/src/main/java/features"
		,glue={"stepDefinitions"},
		dryRun=false,
		monochrome=true,
		plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json"},
		//tags={"@LoginTest,@SmokeTest"}
		tags={"@HomeTest"}
		)
public class login_runner {

}
