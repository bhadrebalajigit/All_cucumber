package Runner;


import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="E:/Mobile_testing/cucumber_framework/src/main/java/features",
		glue={"stepDefinitions"},
		plugin = {"html:target/site/cucumber-pretty","json:target/cucumber.json"},
		dryRun=false,
		tags={"@Test"}
		)

public class test {

}

